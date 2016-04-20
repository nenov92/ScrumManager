package main.events;

import main.Constants;
import main.gui.GUI;
import main.gui.Helper;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

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
public class CheckProductTimeframe implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Event entered: Check Requirements to Start Sprint");
		GUI gui = Helper.getGUI();
		gui.refreshBackground();
		gui.drawToBackground(147, 105);

		Thread.sleep(Constants.SLEEP_MED);

		while (main.Helper.isObligationActive()) {
			Thread.sleep(Constants.SLEEP_MED);
		}
		
		System.out.println("XOR check: More Time?");
		gui.refreshBackground();
		gui.drawToBackground(250, 90);

		Thread.sleep(Constants.SLEEP_TIME);
		
		if (Constants.TIME > 1) {
			System.out.println("XOR result: NO");
			System.out.println("Final event entered: Product Lifecycle Finished");
			gui.refreshBackground();
			gui.drawToBackground(412, 77);

			main.Helper.stopThreads();
			
			execution.getProcessInstance().setVariable("continue", false);
			
			// as the workflow is going into end state refresh the database
			main.Helper.refreshDatabase();
		} else {
			System.out.println("XOR result: YES");
		}
	}
}