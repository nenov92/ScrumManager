package main.events;

import main.Constants;
import main.database.HibernateUtil;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.hibernate.Session;

/**
 * @author Miroslav Nenov
 * Daily meeting Scrum event
 */
public class DailyMeeting implements JavaDelegate {

	/* (non-Javadoc)
	 * method to execute event
	 */
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Daily Meeting");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(577, 250);

		// update environmental state by stating that daily meeting is started
		Session session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("daily", "true", session);
		session.close();

		Thread.sleep(Constants.SLEEP_MED);

		// wait for all obligations to be fulfilled
		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}

		// before leaving this event, update state again
		session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("daily", "false", session);
		main.Helper.updateBlackboardEntryRecord("statusUpdated", "false", session);
		main.Helper.updateBlackboardEntryRecord("underFifteen", "false", session);
		session.close();

		System.out.println("XOR check: More Days for Implementation?");
		gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(682, 237);

		Thread.sleep(Constants.SLEEP_TIME);

		// increase time for each daily meeting 
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