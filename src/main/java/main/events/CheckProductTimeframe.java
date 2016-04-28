package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @author Miroslav Nenov
 * State, where the Scrum Master decides whether to start a new development
 * iteration or not
 */
public class CheckProductTimeframe implements JavaDelegate {

	/* (non-Javadoc)
	 * execute event
	 */
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Check Requirements to Start Sprint");
		
		// update the UI showing current state of the process
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(147, 105);

		Thread.sleep(Constants.SLEEP_MED);

		// wait for all obligations to be fulfilled
		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}

		System.out.println("XOR check: More Time?");
		gui.refreshBackground();
		gui.drawToBackground(250, 90);

		Thread.sleep(Constants.SLEEP_TIME);

		// if there is no more time, end process
		// else start sprint
		if (Constants.TIME > 1) {
			System.out.println("XOR result: NO");
			System.out.println("Final event entered: Product Lifecycle Finished");
			gui.refreshBackground();
			gui.drawToBackground(412, 77);

			// suspend threads
			main.Helper.stopThreads();

			execution.getProcessInstance().setVariable("continue", false);

			// as the workflow is going into end state refresh the database
			main.Helper.refreshDatabase();
		} else {
			System.out.println("XOR result: YES");
		}
	}
}