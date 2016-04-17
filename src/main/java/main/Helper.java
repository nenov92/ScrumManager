package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import main.database.GenericDaoImpl;
import main.database.SessionUtil;
import main.database.BlackboardEntry;
import main.gui.InputConsole;
import main.norms.Norm;
import main.norms.NormChecker;
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
	public static NormChecker normCheckerThread;
	public static ProductOwner productOwnerThread;
	public static ScrumMaster scrumMasterThread;
	
	/**
	 * @param name: BlackboardEntry name
	 * @param value: new value that will replace the old one
	 * 
	 * This method updates entries in the database
	 */
	public static void updateBlackboardEntryRecord(String name, String value) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName(name);
		if (blackboardEntry != null) {
			blackboardEntry.setCurrentValue(value);
			blackboardEntryDao.createOrUpdate(blackboardEntry);
		}
		SessionUtil.commitTransaction();
	}

	/**
	 * @param name: BlackboardEntry name, used to retrieve an entry of int type and increment its current value by 1 
	 */
	public static void incrementBlackboardEntryRecord(String name) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName(name);
		if (blackboardEntry != null) {
			blackboardEntry.setCurrentValue("" + (Integer.parseInt(blackboardEntry.getCurrentValue()) + 1));
			blackboardEntryDao.createOrUpdate(blackboardEntry);
		}
		SessionUtil.commitTransaction();
	}

	/**
	 * @param name: BlackboardEntry name, used to retrieve an entry of int type and decrement its current value by 1 
	 */
	public static void decrementBlackboardEntryRecord(String name) {
		Session session = SessionUtil.getINSTANCE();
		GenericDaoImpl<BlackboardEntry> blackboardEntryDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
		SessionUtil.beginTransaction();
		BlackboardEntry blackboardEntry = blackboardEntryDao.findByBlackboardEntryName(name);
		if (blackboardEntry != null) {
			blackboardEntry.setCurrentValue("" + (Integer.parseInt(blackboardEntry.getCurrentValue()) - 1));
			blackboardEntryDao.createOrUpdate(blackboardEntry);
		}
		SessionUtil.commitTransaction();
	}

	/**
	 * This method returns the original database state; used either before or after the program is run  
	 */
	public static void refreshDatabase() {
		Helper.updateBlackboardEntryRecord("groomingSession", "false");
		Helper.updateBlackboardEntryRecord("activeSprint", "false");
		Helper.updateBlackboardEntryRecord("checkRequirements", "true");
		// Helper.updateBlackboardEntryRecord("task1Assignees", "0");
		Helper.updateBlackboardEntryRecord("taskAssignees", "0");
		Helper.updateBlackboardEntryRecord("planningSession", "true");
	}

	
	/**
	 * Starts a single thread for each user type and another thread for the norm checker 
	 */
	public static void runThreads() {
		normCheckerThread = new NormChecker();
		productOwnerThread = new ProductOwner();
		scrumMasterThread = new ScrumMaster();

		Thread t = new Thread(normCheckerThread);
		Thread t1 = new Thread(productOwnerThread);
		Thread t2 = new Thread(scrumMasterThread);

		t.start();
		t1.start();
		t2.start();
	}

	
	/**
	 * As any previous mechanisms to suspend a thread are deprecated in Java 1.8
	 * internal logic in objects that implement Runnable is the only way to stop the thread's run method from execution 
	 */
	public static void stopThreads() {
		normCheckerThread.terminate();
		productOwnerThread.terminate();
		scrumMasterThread.terminate();
	}

	
	/**
	 * @return boolean
	 * This method checks for any active obligations
	 */
	public static boolean isObligationActive() {
		if (NormChecker.getActiveObligations().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @return boolean
	 * This method checks for any active prohibitions
	 */
	public static boolean isProhibitionActive() {
		if (NormChecker.getActiveProhibitions().size() > 0) {
			return true;
		}
		return false;
	}

	
	/**
	 * @param console: the console belonging to a Scrum participant
	 * @param role: the role of the Scrum participant
	 * 
	 * This method checks for any active norms for the given participant and adds them
	 * the the user console
	 */
	public static void addActiveNormsToConsole(InputConsole console, Role role) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (isObligationActive()) {
			console.getObList().removeAllElements();
			for (Obligation o : NormChecker.getActiveObligations()) {
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
			for (Prohibition p : NormChecker.getActiveProhibitions()) {
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

	/**
	 * @param file: String with the location of norms.conf file in the OS 
	 * @return norm object with loaded sets of obligations and prohibitions
	 * 
	 * This method utilises the functionality provided by the ANTLR 4 parser
	 * 
	 */
	public static Norm loadNorms(String file) {
		InputStream is = System.in;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ANTLRInputStream input = null;
		try {
			// create a CharStream that reads from input
			input = new ANTLRInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create a lexer that uses of input CharStream 
		NormLexer lexer = new NormLexer(input);

		// create a buffer of tokens pulled from the lexer 
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that uses the tokens buffer
		NormParser parser = new NormParser(tokens);
		
		ParseTree tree = parser.prog();
		ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
		NormWalker normWalker = new NormWalker();
		
		// walk through the tree of parsed norms 
		parseTreeWalker.walk(normWalker, tree);

		System.out.println("ANTLR parser has loaded norms");
		return new Norm(normWalker.getObligations(), normWalker.getProhibitions());
	}

}
