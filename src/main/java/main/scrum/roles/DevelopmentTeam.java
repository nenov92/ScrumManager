package main.scrum.roles;

import org.hibernate.Session;

import main.Helper;
import main.database.HibernateUtil;
import main.gui.InputConsole;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class DevelopmentTeam extends ScrumParticipant implements Runnable {
	private static Role role = Role.DEV_TEAM;
	private InputConsole console;
	
	// used to control the life scope of the thread
	private volatile boolean running = true;

	// empty constructor
	public DevelopmentTeam() {
		super(role);
	}

	public Role getRole() {
		return role;
	}

	public InputConsole getConsole() {
		return console;
	}

	public void setConsole(InputConsole console) {
		this.console = console;
	}

	public void closeConsole() {
		this.running = false;
	}
	
	public static void askForClarifications() {
		System.out.println("Development Team: Asking for Clarifications");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("clarificationsAsked", "true", session);
		session.close();
	}
	
	public static void giveTaskEstimation() {
		System.out.println("Development Team: Giving Task Estimation");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("taskEstimation", "true", session);
		session.close();
	}

	public static void updateStatus() {
		System.out.println("Development Team: Giving Status Changes");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("statusUpdated", "true", session);
		session.close();
	}
	
	public static void demonstrateCompletedTasks() {
		System.out.println("Development Team: Demonstrating Completed Tasks");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("demo", "true", session);
		session.close();
	}
	
	public static void giveFeedback() {
		System.out.println("Development Team: Giving Feedback for the Past Sprint");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("feedbackGiven", "true", session);
		session.close();
	}

	@Override
	public void run() {
		console = new InputConsole("Development Team Terminal", new DevelopmentTeam());
		console.setVisible(running);

		System.out.println("Development Team joining workflow");
		while (running) {
			Helper.addActiveNormsToConsole(console, getRole());
		}
	}

	// function that stops the thread from running
	public void terminate() {
		running = false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("; Role: ");
		sb.append(getRole());
		return sb.toString();
	}
}
