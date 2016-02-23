package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckProductTimeframe implements JavaDelegate {
	// private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Check Requirements to Start Sprint");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(147, 105);

		Thread.sleep(1500);

		System.out.println("XOR check: More Time?");
		gui.refreshBackground();
		gui.drawToBackground(250, 90);

		Thread.sleep(1500);

		if (Constants.TIME > 1) {
			System.out.println("XOR result: NO");
			System.out.println("Final event entered: Product Lifecycle Finished");
			gui.refreshBackground();
			gui.drawToBackground(412, 77);

			execution.getProcessInstance().setVariable("continue", false);
		} else {
			System.out.println("XOR result: YES");
		}
	}
}