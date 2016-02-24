package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ImplementationStage implements JavaDelegate {
	// private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Implementation");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(577, 250);

		Thread.sleep(Constants.SLEEP_TIME);

		System.out.println("XOR check: More Days for Implementation?");
		gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(682, 237);

		Thread.sleep(Constants.SLEEP_TIME);

		Constants.TIME += 1;
		if (Constants.TIME > 1) {
			System.out.println("XOR result: NO");
			execution.getProcessInstance().setVariable("implement", false);
		} else {
			System.out.println("XOR result: YES");
			execution.getProcessInstance().setVariable("implement", true);
		}

	}
}