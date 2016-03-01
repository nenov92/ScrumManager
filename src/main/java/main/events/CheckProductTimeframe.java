package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;
import main.norms.NormChecker;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckProductTimeframe implements JavaDelegate {
	// private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Check Requirements to Start Sprint");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(147, 105);

		Thread.sleep(Constants.SLEEP_TIME);

		// check norms which apply to this event
		NormChecker.checkNorms();

		System.out.println("XOR check: More Time?");
		gui.refreshBackground();
		gui.drawToBackground(250, 90);

		Thread.sleep(Constants.SLEEP_TIME);

		if (Constants.TIME > 1) {
			System.out.println("XOR result: NO");
			System.out.println("Final event entered: Product Lifecycle Finished");
			gui.refreshBackground();
			gui.drawToBackground(412, 77);

			execution.getProcessInstance().setVariable("continue", false);
			
			// as the workflow is going into end state refresh the database
			main.Helper.refreshDatabase();
		} else {
			System.out.println("XOR result: YES");
		}
	}
}