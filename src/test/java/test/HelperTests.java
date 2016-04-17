package test;

import static org.junit.Assert.assertTrue;
import main.Helper;
import main.database.BlackboardEntry;
import main.database.GenericDaoImpl;
import main.database.SessionUtil;
import main.norms.Norm;
import main.norms.Prohibition;
import main.scrum.roles.Role;

import org.hibernate.Session;
import org.junit.Test;

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
public class HelperTests {
	
	/**
	 * Test if blackboard table entries are properly updated
	 */
	@Test
	public void updateBlackboardEntryRecordFnUnitTest() {
		// refresh in case any previous tests made changes in the database
		Helper.refreshDatabase();
		
		Helper.updateBlackboardEntryRecord("condition", "false");

		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName("condition");
		SessionUtil.commitTransaction();

		assertTrue("Blackboard entry not properly updated", blackboardEntry.getCurrentValue() == "false");

		// return entry to original state
		Helper.updateBlackboardEntryRecord("condition", "true");
	}
	
	/**
	 * Test if blackboard table entries are properly incremented
	 */
	@Test
	public void incrementBlackboardEntryRecordFnUnitTest() {
		// refresh in case any previous tests made changes in the database
		Helper.refreshDatabase();
		
		Helper.incrementBlackboardEntryRecord("condition2");

		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName("condition2");
		SessionUtil.commitTransaction();

		assertTrue("Blackboard entry not properly updated", blackboardEntry.getCurrentValue().equals("6"));

		// return entry to original state
		Helper.decrementBlackboardEntryRecord("condition2");
	}
	
	/**
	 * Test if blackboard table entries are properly incremented
	 */
	@Test
	public void decrementBlackboardEntryRecordFnUnitTest() {
		// refresh in case any previous tests made changes in the database
		Helper.refreshDatabase();
		
		Helper.decrementBlackboardEntryRecord("condition2");

		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName("condition2");
		SessionUtil.commitTransaction();

		assertTrue("Blackboard entry not properly updated", blackboardEntry.getCurrentValue().equals("4"));

		// return entry to original state
		Helper.incrementBlackboardEntryRecord("condition2");
	}
	
	/**
	 * Test if the ANTLR 4 parser properly gets the input from norms.conf file
	 * location of the file is hardcoded
	 * to use this test please change the location of the file that reflects its absolute path your system
	 */
	@Test
	public void loadNormsFnUnitTest() {
		Norm norm = Helper.loadNorms("F:/Dev/JavaWorkspace/scrum-workflow/src/main/resources/norms.conf");

		assertTrue("Obligations are not loaded", norm.getObligations().size() > 0);
		assertTrue("Prohibitions are not loaded", norm.getProhibitions().size() > 0);

		Prohibition prohibition = new Prohibition(4, Role.SCRUM_MASTER, "assignTask", "task1Assignees == 1 && planningSession == true", "planningSession == false");
		assertTrue("Set of prohibitions does not contain all elements", norm.getProhibitions().contains(prohibition));
	}
}
