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
		Symbol s = symbolDao.findBySymbolName(name);
		if (s != null) {
			s.setCurrentValue(value);
			symbolDao.createOrUpdate(s);
		}
		SessionUtil.commitTransaction();
	}

	public static void refreshDatabase() {
		Helper.updateSymbolRecord("groomingSession", "false");
		Helper.updateSymbolRecord("activeSprint", "false");
		Helper.updateSymbolRecord("checkRequirements", "true");
	}

}
