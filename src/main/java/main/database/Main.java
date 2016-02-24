package main.database;

import org.hibernate.Session;

public class Main {

	public static void main(String args[]) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<Symbol> symbolDao = new GenericDaoImpl<Symbol>(session, Symbol.class);
		//Symbol s = new Symbol("condition3", "bool", "false");
		SessionUtil.beginTransaction();
		//symbolDao.createOrUpdate(s);
		Symbol s = symbolDao.findBySymbolName("condition2");
		System.out.println(s);
		SessionUtil.commitTransaction();
	}
}
