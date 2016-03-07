package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import main.database.GenericDaoImpl;
import main.database.SessionUtil;
import main.database.Symbol;
import main.gui.InputConsole;
import main.norms.Norm;
import main.norms.NormCheck;
import main.norms.Obligation;
import main.norms.Prohibition;
import main.parser.NormLexer;
import main.parser.NormParser;
import main.parser.NormWalker;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.Role;
import main.scrum.roles.ScrumMaster;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
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

	public static void decrementSymbolRecord(String name) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<Symbol> symbolDao = new GenericDaoImpl<Symbol>(session, Symbol.class);
		SessionUtil.beginTransaction();
		Symbol symbol = symbolDao.findBySymbolName(name);
		if (symbol != null) {
			symbol.setCurrentValue("" + (Integer.parseInt(symbol.getCurrentValue()) - 1));
			symbolDao.createOrUpdate(symbol);
		}
		SessionUtil.commitTransaction();
	}

	public static void refreshDatabase() {
		Helper.updateSymbolRecord("groomingSession", "false");
		Helper.updateSymbolRecord("activeSprint", "false");
		Helper.updateSymbolRecord("checkRequirements", "true");
		// Helper.updateSymbolRecord("task1Assignees", "0");
		Helper.updateSymbolRecord("taskAssignees", "0");
		Helper.updateSymbolRecord("planningSession", "true");
	}

	public static void runThreads() {
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

	public static boolean isProhibitionActive() {
		if (NormCheck.getActiveProhibitions().size() > 0) {
			return true;
		}
		return false;
	}

	public static void addActiveNormsToConsole(InputConsole console, Role role) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (isObligationActive()) {
			console.getObList().removeAllElements();
			for (Obligation o : NormCheck.getActiveObligations()) {
				if (o.getRoleId() == role) {
					console.getObList().addElement(o.getActionFunction());
				}
			}
		} else {
			if (console.getObList().size() > 0) {
				console.getObList().removeAllElements();
			}
		}

		if (isProhibitionActive()) {
			console.getProhList().removeAllElements();
			for (Prohibition p : NormCheck.getActiveProhibitions()) {
				if (p.getRoleId() == role) {
					console.getProhList().addElement(p.getPerform());
				}
			}
		} else {
			if (console.getProhList().size() > 0) {
				console.getProhList().removeAllElements();
			}
		}
	}

	public static Norm loadNorms() {
		InputStream is = System.in;
		try {
			is = new FileInputStream(Constants.NORMS_FILE_ON_SERVER);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ANTLRInputStream input = null;
		try {
			input = new ANTLRInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		NormLexer lexer = new NormLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		NormParser parser = new NormParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
		NormWalker normWalker = new NormWalker();
		parseTreeWalker.walk(normWalker, tree);

		System.out.println("ANTLR parser has loaded norms");
		return new Norm(normWalker.getObligations(), normWalker.getProhibitions());
	}

}
