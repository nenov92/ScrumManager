package main;

import main.database.GenericDaoImpl;
import main.database.SessionUtil;
import main.database.Symbol;

import org.hibernate.Session;

public class Helper {

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

}
