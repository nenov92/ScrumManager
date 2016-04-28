package test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import main.database.BlackboardEntry;
import main.database.GenericDaoImpl;
import main.database.HibernateUtil;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author Miroslav Nenov
 * unit tests for the database functionality
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
		session = HibernateUtil.getSessionfactory().openSession();
		blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
	}

	/**
	 * before running each test open transaction to the database 
	 */
	@Before
	public void beginTransaction() {
		session.beginTransaction();
	}

	/**
	 * after a test is run, commit the transaction to the database 
	 */
	@After
	public void commitTransaction() {
		session.getTransaction().commit();
	}

	/**
	 * Finally after all tests are run, close the session to the database
	 */
	@AfterClass
	public static void closeRunningSession() {
		session.close();
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
