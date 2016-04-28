package main;

import static org.camunda.bpm.engine.variable.Variables.createVariables;

import java.io.IOException;

import main.database.HibernateUtil;
import main.gui.Console;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;
import org.hibernate.Session;

/**
 * @author Miroslav Nenov
 *
 */
@ProcessApplication("Scrum Workflow App")
public class ScrumWorkflowApplication extends ServletProcessApplication {

	/**
	 * @param engine Camunda engine
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 * This method starts the engine executing the BPMN specification of the Scrum process  
	 */
	@PostDeploy
	public void startProcess(ProcessEngine engine) throws IOException, InterruptedException {
		// return the database to its original state 
		main.Helper.refreshDatabase();
		
		// start an admin console
		new Console();

		System.out.println("Workflow Process Engine Started");
		System.out.println("Workflow Specifications Loaded");
		System.out.println("Start event entered: Product Order Received");
		new Helper(new GUI(40, 77));

		Thread.sleep(Constants.SLEEP_TIME);

		// start threads for Norm Checker, Product Owner, Scrum Master and Development Team
		main.Helper.runThreads();

		Thread.sleep(Constants.SLEEP_MED);

		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}
		
		// start session to the database and update the current enveronmental state
		Session session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("scrumStart", "false", session);
		main.Helper.updateBlackboardEntryRecord("checkRequirements", "true", session);
		main.Helper.updateBlackboardEntryRecord("activeSprint", "false", session);
		session.close();

		// start the process by name
		engine.getRuntimeService().startProcessInstanceByKey("scrum-workflow",
				createVariables().putValue("continue", true).putValue("implement", false));
	}

}
