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
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
		
		Thread.sleep(Constants.SLEEP_MED);
		
		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}
		Session session = HibernateUtil.getSessionfactory().openSession();
		main.Helper.updateBlackboardEntryRecord("scrumStart", "false", session);
		main.Helper.updateBlackboardEntryRecord("checkRequirements", "true", session);
		main.Helper.updateBlackboardEntryRecord("activeSprint", "false", session);

		session.close();
		
		engine.getRuntimeService().startProcessInstanceByKey("scrum-workflow",
				createVariables().putValue("continue", true).putValue("implement", false));
	}

}
