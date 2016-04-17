package test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.database.BlackboardEntry;
import main.database.GenericDaoImpl;
import main.database.SessionUtil;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // order methods according to their name (starting from A to Z) and run them in this order
public class DatabaseOperationTests {

	static GenericDaoImpl<BlackboardEntry> blackboardEntryDao;
	static Session session;

	/**
	 * Before running any of the unit tests, initialize a singleton session
	 * object Also, initialize the data access object
	 */
	@BeforeClass
	public static void initializeSession() {
		session = SessionUtil.getINSTANCE();
		blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
	}

	/**
	 * before running each test open transaction to the database 
	 */
	@Before
	public void beginTransaction() {
		// verify that if session was not closed, if so create new instance
		if (!session.isOpen()) {
			session = SessionUtil.getINSTANCE();
			blackboardEntryDao.setCurrentSession(session);
		}
		SessionUtil.beginTransaction();
	}

	/**
	 * after a test is run, commit the transaction to the database 
	 */
	@After
	public void commitTransaction() {
		SessionUtil.commitTransaction();
	}

	/**
	 * Finally after all tests are run, close the session to the database
	 */
	@AfterClass
	public static void closeRunningSession() {
		SessionUtil.closeSession();
	}
	
	/**
	 * Test if data access object can create objects in the database
	 */
	@Test
	public void A_CreateFnUnitTest(){
		BlackboardEntry blackboardEntry = new BlackboardEntry("testCondition", "bool", "true");
		blackboardEntryDao.createOrUpdate(blackboardEntry);
		
		BlackboardEntry databaseEntry = blackboardEntryDao.findByBlackboardEntryName("testCondition");
		assertTrue("Entry not found", blackboardEntry.equals(databaseEntry));
		assertTrue("Entry is not the same", blackboardEntry.getCurrentValue().equals(databaseEntry.getCurrentValue()));
	}

	/**
	 * Test if data access object can create objects in the database
	 */
	@Test
	public void B_UpdateFnUnitTest(){
		BlackboardEntry databaseEntry = blackboardEntryDao.findByBlackboardEntryName("testCondition");
		databaseEntry.setCurrentValue("false");
		blackboardEntryDao.createOrUpdate(databaseEntry);
		
		BlackboardEntry databaseEntry2 = blackboardEntryDao.findByBlackboardEntryName("testCondition");
		assertTrue("Entry is not properly updated", databaseEntry2.getCurrentValue().equals("false"));
	}

	/**
	 * Test if data access object can create objects in the database
	 */
	@Test
	public void C_DeleteFnUnitTest(){
		BlackboardEntry databaseEntry = blackboardEntryDao.findByBlackboardEntryName("testCondition");
		blackboardEntryDao.delete(databaseEntry);
		
		BlackboardEntry databaseEntry2 = blackboardEntryDao.findByBlackboardEntryName("testCondition");
		assertNull("Entry is not deleted", databaseEntry2);;
	}
	
}
