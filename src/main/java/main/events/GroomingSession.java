package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GroomingSession implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Grooming Session");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(250, 250);

		main.Helper.updateBlackboardEntryRecord("groomingSession", "true");
		
		Thread.sleep(Constants.SLEEP_MED);
		
		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}
		
		main.Helper.updateBlackboardEntryRecord("groomingSession", "false");
	}
}