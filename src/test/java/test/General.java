package test;

import java.util.HashSet;
import java.util.Set;

import main.norms.ActionFunction;
import main.norms.ConditionEvaluator;
import main.norms.Norm;
import main.norms.NormChecker;
import main.norms.Obligation;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class General {

	@Test
	public void evaluatorTest() {
		String expression = "true == true && 5 > 3 || true == false";
		boolean result = ConditionEvaluator.evaluate(expression);
		assertTrue("Error", result);

		expression = "false == true";
		result = ConditionEvaluator.evaluate(expression);
		assertFalse("Error", result);

		expression = "false == !true";
		result = ConditionEvaluator.evaluate(expression);
		assertTrue("Error", result);
	}

	@Test
	public void normObligationTest() {
		Set<ScrumParticipant> participants = new HashSet<ScrumParticipant>();
		ProductOwner p = new ProductOwner("Jack");
		participants.add(p);
		
		Obligation obligation = new Obligation(10, Role.PRODUCT_OWNER, "startSprint", "condition == true && condition2 > 3 || condition3 == false", "condition == false", "condition == true", "");
		Norm norm = new Norm();
		norm.addObligation(obligation);
		
		//NormChecker.checkObligations(norm, participants);
	}
}
