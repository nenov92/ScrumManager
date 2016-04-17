package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.Helper;
import main.norms.NormChecker;
import main.scrum.roles.ProductOwner;

import org.junit.Test;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class ScrumRolesTests {
	
	/**
	 * This test checks if the user console properly displays norms 
	 * @throws InterruptedException
	 */
	@Test
	public void startSprintFnUnitTest() throws InterruptedException {
		// refresh in case any previous tests made changes in the database
		Helper.refreshDatabase();

		// start a new thread running the normChecker
		NormChecker normChecker = new NormChecker("F:/Dev/JavaWorkspace/scrum-workflow/src/main/resources/norms.conf");
		ProductOwner productOwner = new ProductOwner("Sam");

		Thread thread = new Thread(normChecker);
		Thread thread1 = new Thread(productOwner);
		thread.start();
		thread1.start();

		Thread.sleep(7000);

		// this is a known obligation of the product owner, test if the user console displays this obligation
		boolean obligBool = productOwner.getConsole().getObList().contains("startSprint");
		assertTrue("Activation of prohibitions is not correct", obligBool);

		productOwner.startSprint();

		Thread.sleep(7000);

		// after the action is performed by the product owner, the console of
		// this user should no more display it as active obligation
		obligBool = productOwner.getConsole().getObList().contains("startSprint");
		assertFalse("Activation of prohibitions is not correct", obligBool);

		// terminate both threads
		normChecker.terminate();
		productOwner.terminate();
		
		// return the database to its previous state
		Helper.refreshDatabase();
	}
}
