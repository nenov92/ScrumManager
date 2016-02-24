package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RetrospectiveMeeting implements JavaDelegate {
	// private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Retrospective Meeting");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(1025, 250);

		Thread.sleep(Constants.SLEEP_TIME);

	}
}