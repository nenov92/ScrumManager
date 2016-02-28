package main;

import static org.camunda.bpm.engine.variable.Variables.createVariables;

import java.io.IOException;
import java.util.logging.Logger;

import main.gui.Console;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.authorization.Groups;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;

@ProcessApplication("Scrum Workflow App")
public class ScrumWorkflowApplication extends ServletProcessApplication {

	private final Logger LOGGER = Logger.getLogger(ScrumWorkflowApplication.class.getName());

	@PostDeploy
	public void startProcess(ProcessEngine engine) throws IOException, InterruptedException {
		new Console();

		System.out.println("Workflow Process Engine Started");
		System.out.println("Workflow Specifications Loaded");
		System.out.println("Start event entered: Product Order Received");
		new Helper(new GUI(40, 77));

		Thread.sleep(Constants.SLEEP_TIME);

		engine.getRuntimeService().startProcessInstanceByKey("scrum-workflow",
				createVariables().putValue("continue", true).putValue("implement", false));
	}

	@SuppressWarnings("unused")
	private void startProcessInstance(ProcessEngine engine) {
		engine.getRuntimeService().startProcessInstanceByKey("scrum-workflow",
				createVariables().putValue("continue", true).putValue("implement", false));

		// engine.getIdentityService().setAuthentication("po",
		// Arrays.asList(Groups.CAMUNDA_ADMIN));
		// Task task =
		// engine.getTaskService().createTaskQuery().processInstanceId(pi.getId()).singleResult();
		// engine.getTaskService().claim(task.getId(), "po");
		// engine.getTaskService().complete(task.getId(),
		// createVariables().putValue("continue", true));
	}

	@SuppressWarnings("unused")
	private void createUsers(ProcessEngine engine) {
		final IdentityService identityService = engine.getIdentityService();

		if (identityService.isReadOnly()) {
			LOGGER.info("Identity service provider is Read Only, not creating any demo users.");
			return;
		}

		User singleResult = identityService.createUserQuery().userId("po").singleResult();
		if (singleResult != null) {
			return;
		}

		LOGGER.info("Generating demo data for invoice showcase");

		User user = identityService.newUser("po");
		user.setFirstName("Product");
		user.setLastName("Owner");
		user.setPassword("po");
		identityService.saveUser(user);

		// create group
		if (identityService.createGroupQuery().groupId(Groups.CAMUNDA_ADMIN).count() == 0) {
			Group camundaAdminGroup = identityService.newGroup(Groups.CAMUNDA_ADMIN);
			camundaAdminGroup.setName("camunda BPM Administrators");
			camundaAdminGroup.setType(Groups.GROUP_TYPE_SYSTEM);

			identityService.saveGroup(camundaAdminGroup);
		}

	}
}
