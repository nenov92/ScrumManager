package main;

import static org.camunda.bpm.engine.variable.Variables.createVariables;

import java.util.Arrays;
import java.util.logging.Logger;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.authorization.Groups;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.runtime.ProcessInstance;

@ProcessApplication("Scrum Workflow App")
public class ScrumWorkflowApplication extends ServletProcessApplication {

	private final Logger LOGGER = Logger.getLogger(ScrumWorkflowApplication.class.getName());

	@PostDeploy
	public void startProcess(ProcessEngine engine) {
		LOGGER.info("Process Engine Started");

		//createUsers(engine);
		startProcessInstance(engine);
	}

	private void startProcessInstance(ProcessEngine engine) {
		ProcessInstance pi = engine.getRuntimeService().startProcessInstanceByKey("scrum-workflow",
				createVariables().putValue("continue", true).putValue("implement", false));
		engine.getIdentityService().setAuthentication("po", Arrays.asList(Groups.CAMUNDA_ADMIN));
		//Task task = engine.getTaskService().createTaskQuery().processInstanceId(pi.getId()).singleResult();
		//engine.getTaskService().claim(task.getId(), "po");
		//engine.getTaskService().complete(task.getId(), createVariables().putValue("continue", true));
	}

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
