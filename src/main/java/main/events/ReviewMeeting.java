package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReviewMeeting implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Review Meeting");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(845, 250);

		main.Helper.updateBlackboardEntryRecord("review", "true");
		
		Thread.sleep(Constants.SLEEP_MED);
		
		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}

		main.Helper.updateBlackboardEntryRecord("retrospective", "false");
	}
}