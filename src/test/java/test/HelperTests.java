package test;

import static org.junit.Assert.assertTrue;
import main.Helper;
import main.database.BlackboardEntry;
import main.database.GenericDaoImpl;
import main.database.HibernateUtil;
import main.norms.Norm;
import main.norms.Prohibition;
import main.scrum.roles.Role;

import org.hibernate.Session;
import org.junit.Test;

/**
 * @author Miroslav Nenov
 * unit tests for the functionality offered by the utility class
 */
public class HelperTests {
	
	/**
	 * Test if blackboard table entries are properly updated
	 */
	@Test
	public void updateBlackboardEntryRecordFnUnitTest() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("condition", "false", session);

		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		session.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName("condition");
		session.getTransaction().commit();

		assertTrue("Blackboard entry not properly updated", blackboardEntry.getCurrentValue() == "false");

		// return entry to original state
		Helper.updateBlackboardEntryRecord("condition", "true", session);
	}
	
	/**
	 * Test if blackboard table entries are properly incremented
	 */
	@Test
	public void incrementBlackboardEntryRecordFnUnitTest() {
		Session session = HibernateUtil.getSessionfactory().openSession();

		Helper.incrementBlackboardEntryRecord("condition2", session);

		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		session.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName("condition2");
		session.getTransaction().commit();

		assertTrue("Blackboard entry not properly updated", blackboardEntry.getCurrentValue().equals("6"));

		// return entry to original state
		Helper.decrementBlackboardEntryRecord("condition2", session);
		session.close();
	}
	
	/**
	 * Test if blackboard table entries are properly incremented
	 */
	@Test
	public void decrementBlackboardEntryRecordFnUnitTest() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		Helper.decrementBlackboardEntryRecord("condition2", session);

		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		session.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName("condition2");
		session.getTransaction().commit();

		assertTrue("Blackboard entry not properly updated", blackboardEntry.getCurrentValue().equals("4"));

		// return entry to original state
		Helper.incrementBlackboardEntryRecord("condition2", session);
		session.close();
	}
	
	/**
	 * Test if the ANTLR 4 parser properly gets the input from norms.conf file
	 * location of the file is hardcoded; to use this test please change the location of the file 
	 * that reflects its absolute path your system
	 */
	@Test
	public void loadNormsFnUnitTest() {
		Norm norm = Helper.loadNorms("F:/Dev/JavaWorkspace/ScrumManager/src/main/resources/norms.conf");

		assertTrue("Obligations are not loaded", norm.getObligations().size() > 0);
		assertTrue("Prohibitions are not loaded", norm.getProhibitions().size() > 0);

		Prohibition prohibition = new Prohibition(16, Role.PRODUCT_OWNER, "changeTaskEstimation", "planningSession == true", "planningSession == false", "estimationChanged == true");
		assertTrue("Set of prohibitions does not contain all elements", norm.getProhibitions().contains(prohibition));
	}
}
