package main;

import main.database.GenericDaoImpl;
import main.database.SessionUtil;
import main.database.Symbol;
import main.norms.NormCheck;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.ScrumMaster;

import org.hibernate.Session;

public class Helper {
	public static NormCheck n;
	public static Thread t;
	public static Thread t1;
	public static Thread t2;

	public static void updateSymbolRecord(String name, String value) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<Symbol> symbolDao = new GenericDaoImpl<Symbol>(session, Symbol.class);
		SessionUtil.beginTransaction();
		Symbol symbol = symbolDao.findBySymbolName(name);
		if (symbol != null) {
			symbol.setCurrentValue(value);
			symbolDao.createOrUpdate(symbol);
		}
		SessionUtil.commitTransaction();
	}

	public static void incrementSymbolRecord(String name) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<Symbol> symbolDao = new GenericDaoImpl<Symbol>(session, Symbol.class);
		SessionUtil.beginTransaction();
		Symbol symbol = symbolDao.findBySymbolName(name);
		if (symbol != null) {
			symbol.setCurrentValue("" + (Integer.parseInt(symbol.getCurrentValue()) + 1));
			symbolDao.createOrUpdate(symbol);
		}
		SessionUtil.commitTransaction();
	}

	public static void refreshDatabase() {
		Helper.updateSymbolRecord("groomingSession", "false");
		Helper.updateSymbolRecord("activeSprint", "false");
		Helper.updateSymbolRecord("checkRequirements", "true");
		Helper.updateSymbolRecord("task1Assignees", "0");
		Helper.updateSymbolRecord("planningSession", "true");
	}

	public static void runThreads() {
		Helper.refreshDatabase();
		n = new NormCheck();
		ProductOwner p = new ProductOwner();
		ScrumMaster s = new ScrumMaster();

		t = new Thread(n);
		t1 = new Thread(p);
		t2 = new Thread(s);

		t.start();
		t1.start();
		t2.start();
	}

	public static void stopThreads() {
		n.terminate();
	}

	public static boolean isObligationActive() {
		if (NormCheck.getActiveObligations().size() > 0) {
			return true;
		}
		return false;
	}

}
