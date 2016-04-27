package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import main.Helper;
import main.database.HibernateUtil;
import main.norms.ConditionEvaluator;
import main.norms.Norm;
import main.norms.NormChecker;
import main.norms.Obligation;
import main.norms.Prohibition;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.Role;

import org.hibernate.Session;
import org.junit.Test;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class NormCheckerTests {

	/**
	 * Test if the evaluate method of ConditionEvaluator works as expected
	 */
	@Test
	public void evaluateFnUnitTest() {
		String expression = "true == true && 5 > 3 || true == false";
		Boolean result = ConditionEvaluator.evaluate(expression);
		assertTrue("Incorrectly evaluated expression", result); // the string describes what message output should be printed whenever this test fails

		expression = "false == true";
		result = ConditionEvaluator.evaluate(expression);
		assertFalse("Incorrectly evaluated expression", result);

		expression = "false == !true";
		result = ConditionEvaluator.evaluate(expression);
		assertTrue("Incorrectly evaluated expression", result);

		expression = "";
		result = ConditionEvaluator.evaluate(expression);
		assertTrue("Incorrectly evaluated expression", result == null);
	}

	/**
	 * Test if the processConditions method of ConditionEvaluator works as expected
	 */
	@Test
	public void processConditionsFnUnitTest() {
		// refresh in case any previous tests made changes in the database
		Helper.refreshDatabase();
		
		String expression = "condition == false && condition2 < 6 || condition3 != false || condition4 > 10";

		Session session = HibernateUtil.getSessionfactory().openSession();
		String result = ConditionEvaluator.processConditions(expression, session);
		session.close();
		assertTrue("Incorrectly processed condition", result.equals("true == false && 5 < 6 || false != false || 10 > 10"));
	}
	
	/**
	 * Test if the the norm holds just one unique instance of an obligation or a prohibition
	 * basically the overridden methods hashCode and equals of Obligation and Prohibition objects are tested
	 */
	@Test
	public void normUniquenessTestFnUnitTest() {
		Norm norm = new Norm();
		int obligSetSize = 0;
		int prohSetSize = 0;

		Obligation obligation = new Obligation(10, Role.PRODUCT_OWNER, "action", "condition == true && condition2 > 3", "condition == false", "condition == true", "condition2 < 3");
		Prohibition prohibition = new Prohibition(1, Role.SCRUM_MASTER, "assignTask", "task1Assignees == 1 && planningSession == true", "planningSession == false", "condition == true");

		norm.addObligation(obligation);
		norm.addProhibition(prohibition);

		obligSetSize = norm.getObligations().size();
		prohSetSize = norm.getProhibitions().size();

		norm.addObligation(obligation);
		norm.addProhibition(prohibition);

		assertTrue("Uniqueness of the set of obligations is not guaranteed", obligSetSize == norm.getObligations().size());
		assertTrue("Uniqueness of the set of prohibitions is not guaranteed", prohSetSize == norm.getProhibitions().size());
	}
	
	/**
	 * Test of the function that checks if any prohibition for a given role is already enforced; used to control precedence between deontic modalities
	 */
	@Test
	public void isActionProhibitedFnUnitTest() {
		Prohibition prohibition = new Prohibition(1, Role.SCRUM_MASTER, "assignTask", "task1Assignees == 1 && planningSession == true", "planningSession == false", "condition == true");
		Prohibition prohibition1 = new Prohibition(2, Role.DEV_TEAM, "completeTask", "taskCompleted == true", "implementationStage == false", "condition == true");

		Set<Prohibition> prohibitions = new HashSet<Prohibition>();
		prohibitions.add(prohibition);
		prohibitions.add(prohibition1);

		boolean result = NormChecker.isActionProhibited(Role.SCRUM_MASTER, "assignTask", prohibitions);
		boolean result1 = NormChecker.isActionProhibited(Role.DEV_TEAM, "completeTask", prohibitions);
		boolean result2 = NormChecker.isActionProhibited(Role.PRODUCT_OWNER, "defineDone", prohibitions);

		assertTrue("Incorrect behaviour of isActionProhibited", result == true);
		assertTrue("Incorrect behaviour of isActionProhibited", result1 == true);
		assertTrue("Incorrect behaviour of isActionProhibited", result2 == false);
	}
	
	/**
	 * Test whether the Norm Checker correctly activates obligations
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void activationOfObligationsTest() throws InterruptedException {
		// refresh in case any previous tests made changes in the database
		Helper.refreshDatabase();
		
		// start a new thread running the normChecker
		NormChecker normChecker = new NormChecker("F:/Dev/JavaWorkspace/ScrumManager/src/main/resources/norms.conf");
		Thread thread = new Thread(normChecker);
		thread.start();

		Obligation obligation = new Obligation(1, Role.SCRUM_MASTER, "defineWhenTaskIsDone", "scrumStart == true", "scrumStart == false || dodCompleted == true", "dodCompleted == true", "dodCompleted == false");

		Thread.sleep(5000);
		boolean obligBool = normChecker.getActiveObligations().contains(obligation);

		assertTrue("Activation of obligations is not correct", obligBool);

		// terminate the threads
		normChecker.terminate();
	}
	
	/**
	 * Test whether the Norm Checker correctly activates prohibitions
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("static-access")
	@Test
	public void activationOfProhibitionsTest() throws InterruptedException {
		// start a new thread running the normChecker
		NormChecker normChecker = new NormChecker("F:/Dev/JavaWorkspace/ScrumManager/src/main/resources/norms.conf");
		ProductOwner productOwner = new ProductOwner("Sam");

		Thread thread = new Thread(normChecker);
		Thread thread1 = new Thread(productOwner);
		thread.start();
		thread1.start();

		// this action of the scrum master activates the prohibition defined below so that it can be tested
		Thread.sleep(9000);
		Session session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("planningSession", "true",session);
		session.close();

		Prohibition prohibition = new Prohibition(16, Role.PRODUCT_OWNER, "changeTaskEstimation", "planningSession == true", "planningSession == false", "estimationChanged == true");

		Thread.sleep(10000);
		boolean prohBool = normChecker.getActiveProhibitions().contains(prohibition);

		assertTrue("Activation of prohibitions is not correct", prohBool);
		
		// terminate both threads
		normChecker.terminate();
		productOwner.terminate();
		
		// return the database to its previous state
		Helper.refreshDatabase();
	}
}
