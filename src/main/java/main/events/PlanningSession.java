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
 * Planning Session event
 */
public class PlanningSession implements JavaDelegate {

	/* (non-Javadoc)
	 * method to execute event
	 */
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Planning Session");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(415, 250);

		// update environmental state by stating that daily meeting is started
		Session session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("planningSession", "true", session);
		session.close();

		Thread.sleep(Constants.SLEEP_MED);

		// wait for all obligations to be fulfilled
		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}

		// before leaving this event, update state again
		session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("planningSession", "false", session);
		session.close();
	}
}