package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.Helper;
import main.norms.NormChecker;
import main.scrum.roles.ScrumMaster;

import org.junit.Test;


/**
 * @author Miroslav Nenov
 * unit tests for the functionality offered by the scrum roles classes
 */
public class ScrumRolesTests {
	
	/**
	 * This test checks if the user console properly displays norms 
	 * @throws InterruptedException
	 */
	@Test
	public void startSprintFnUnitTest() throws InterruptedException {
		// start a new thread running the normChecker
		NormChecker normChecker = new NormChecker("F:/Dev/JavaWorkspace/ScrumManager/src/main/resources/norms.conf");
		ScrumMaster scrumMaster = new ScrumMaster("Sam");

		Thread thread = new Thread(normChecker);
		Thread thread1 = new Thread(scrumMaster);
		thread.start();
		thread1.start();

		Thread.sleep(7000);

		// this is a known obligation of the product owner, test if the user console displays this obligation
		boolean obligBool = scrumMaster.getConsole().getObList().contains("defineWhenTaskIsDone");
		assertTrue("Activation of obligations is not correct", obligBool);

		scrumMaster.startSprint();

		Thread.sleep(7000);

		// after the action is performed by the product owner, the console of
		// this user should no more display it as active obligation
		obligBool = scrumMaster.getConsole().getObList().contains("startSprint");
		assertFalse("Activation of obligations is not correct", obligBool);

		// terminate both threads
		normChecker.terminate();
		scrumMaster.terminate();
		
		// return the database to its previous state
		Helper.refreshDatabase();
	}
}
