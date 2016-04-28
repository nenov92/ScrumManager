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
public class ProductOwner extends ScrumParticipant implements Runnable {
	private static Role role = Role.PRODUCT_OWNER;
	private String name;
	private InputConsole console;
	
	// used to control the life scope of the thread
	private volatile boolean running = true;

	// empty constructor
	public ProductOwner() {
	}

	public ProductOwner(String name) {
		super(role);
		this.setName(name);
	}

	public Role getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputConsole getConsole() {
		return console;
	}

	public void setConsole(InputConsole console) {
		this.console = console;
	}

	// obligation for this role
	public static void prepareBacklog() {
		System.out.println("Product Owner: Preparing Backlog");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("backlog", "true", session);
		session.close();
	}
	
	// obligation for this role
	public static void sortBacklog() {
		System.out.println("Product Owner: Sorting Backlog");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("backlogSorted", "true", session);
		session.close();
	}
	
	// obligation for this role
	public static void giveClarifications() {
		System.out.println("Product Owner: Giving Clarifications");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("clarificationsGiven", "true", session);
		session.close();
	}
	
	// prohibition for this role
	public static void changeTaskEstimation() {
		System.out.println("Product Owner: Illegally Changing Task Estimations");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("estimationChanged", "true", session);
		session.close();
	}
	
	// obligation for this role
	public static void removeEstimationChange() {
		System.out.println("Product Owner: Removing Illegally Changed Task Estimations");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("estimationChanged", "false", session);
		session.close();
	}
	
	public void closeConsole() {
		this.running = false;
	}

	/* (non-Javadoc)
	 * start the thread to run 
	 * while running at a time interval check for active associated norms
	 */
	@Override
	public void run() {
		console = new InputConsole("Product Owner Terminal", new ProductOwner("Sam"));
		console.setVisible(true);

		System.out.println("Product Owner joining workflow");
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
		sb.append("Name: ");
		sb.append(getName());
		sb.append("; Role: ");
		sb.append(getRole());
		return sb.toString();
	}
}
