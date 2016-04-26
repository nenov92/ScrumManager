package main.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class Main {

	public static void main(String args[]) {
		List<BlackboardEntry> entries = new ArrayList<BlackboardEntry>();
		entries.add(new BlackboardEntry("daily", "bool", "false"));
		entries.add(new BlackboardEntry("review", "bool", "false"));
		entries.add(new BlackboardEntry("retrospective", "bool", "false"));
		
		entries.add(new BlackboardEntry("statusUpdated", "bool", "false"));
		entries.add(new BlackboardEntry("underFifteen", "bool", "false"));
		entries.add(new BlackboardEntry("demo", "bool", "false"));
		entries.add(new BlackboardEntry("feedbackGiven", "bool", "false"));
		
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		for (BlackboardEntry b : entries){
			System.out.println(b);
			blackboardEntryDao.createOrUpdate(b);
		}
		SessionUtil.commitTransaction();
	}
}
