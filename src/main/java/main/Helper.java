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

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class Helper {
	public static NormCheck normCheckerThread;
	public static ProductOwner productOwnerThread;
	public static ScrumMaster scrumMasterThread;
	
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
		normCheckerThread = new NormCheck();
		productOwnerThread = new ProductOwner();
		scrumMasterThread = new ScrumMaster();

		Thread t = new Thread(normCheckerThread);
		Thread t1 = new Thread(productOwnerThread);
		Thread t2 = new Thread(scrumMasterThread);

		t.start();
		t1.start();
		t2.start();
	}

	public static void stopThreads() {
		normCheckerThread.terminate();
		productOwnerThread.terminate();
		scrumMasterThread.terminate();
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
					console.getProhList().addElement(p.getActionName());
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
