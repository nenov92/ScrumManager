package main.events;

import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GroomingSession implements JavaDelegate {
	// private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Grooming Session");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(250, 250);

		Thread.sleep(1500);
	}
}