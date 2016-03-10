package main;

import static org.camunda.bpm.engine.variable.Variables.createVariables;

import java.io.IOException;

import main.gui.Console;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

@ProcessApplication("Scrum Workflow App")
public class ScrumWorkflowApplication extends ServletProcessApplication {

	@PostDeploy
	public void startProcess(ProcessEngine engine) throws IOException, InterruptedException {
		main.Helper.refreshDatabase();
		new Console();

		System.out.println("Workflow Process Engine Started");
		System.out.println("Workflow Specifications Loaded");
		System.out.println("Start event entered: Product Order Received");
		new Helper(new GUI(40, 77));

		Thread.sleep(Constants.SLEEP_TIME);

		main.Helper.runThreads();

		engine.getRuntimeService().startProcessInstanceByKey("scrum-workflow",
				createVariables().putValue("continue", true).putValue("implement", false));
	}

}
