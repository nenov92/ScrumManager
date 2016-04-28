package main.scrum.roles;

import org.hibernate.Session;

import main.Helper;
import main.database.HibernateUtil;
import main.gui.InputConsole;


/**
 * @author Miroslav Nenov
 * One of the three Scrum roles, inherits Scrum participant
 * runs on a single thread concurrently with the other roles
 */
public class DevelopmentTeam extends ScrumParticipant implements Runnable {
	private static Role role = Role.DEV_TEAM;
	
	// personal user console
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
	
	// obligation for this role
	public static void askForClarifications() {
		System.out.println("Development Team: Asking for Clarifications");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("clarificationsAsked", "true", session);
		session.close();
	}

	// obligation for this role
	public static void giveTaskEstimation() {
		System.out.println("Development Team: Giving Task Estimation");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("taskEstimation", "true", session);
		session.close();
	}

	// obligation for this role
	public static void updateStatus() {
		System.out.println("Development Team: Giving Status Changes");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("statusUpdated", "true", session);
		session.close();
	}
	
	// obligation for this role
	public static void demonstrateCompletedTasks() {
		System.out.println("Development Team: Demonstrating Completed Tasks");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("demo", "true", session);
		session.close();
	}
	
	// obligation for this role
	public static void giveFeedback() {
		System.out.println("Development Team: Giving Feedback for the Past Sprint");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("feedbackGiven", "true", session);
		session.close();
	}

	/* (non-Javadoc)
	 * start the thread to run 
	 * while running at a time interval check for active associated norms
	 */
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
