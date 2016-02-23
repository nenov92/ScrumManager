package main.events;

import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReviewMeeting implements JavaDelegate {
	// private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Review Meeting");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(845, 250);

		Thread.sleep(1500);

	}
}