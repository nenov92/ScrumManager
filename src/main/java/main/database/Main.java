package main.database;

import org.hibernate.Session;

public class Main {

	public static void main(String args[]) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		BlackboardEntry b = new BlackboardEntry("taskAssignees", "int", "0");
		SessionUtil.beginTransaction();
		// Symbol b = blackboardEntryDao.findByBlackboardEntryDaoName("task1Assignees");
		// b.setCurrentValue("0");
		blackboardEntryDao.createOrUpdate(b);
		System.out.println(b);
		SessionUtil.commitTransaction();
	}
}
