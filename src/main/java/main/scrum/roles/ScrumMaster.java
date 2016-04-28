package main.scrum.roles;

import org.hibernate.Session;

import main.Helper;
import main.database.HibernateUtil;
import main.gui.InputConsole;

/**
 * @author Miroslav Nenov 
 * One of the three Scrum roles, inherits Scrum
 * participant runs on a single thread concurrently with the other roles
 */
public class ScrumMaster extends ScrumParticipant implements Runnable {
	private static Role role = Role.SCRUM_MASTER;
	private String name;
	private InputConsole console;

	// used to control the life scope of the thread
	private volatile boolean running = true;

	// empty constructor
	public ScrumMaster() {
	}

	public ScrumMaster(String name) {
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
	public static void defineWhenTaskIsDone() {
		System.out.println("Scrum Master: Setting Definition of Done for tasks");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("dodCompleted", "true", session);
		session.close();
	}

	// obligation for this role
	public static void setSprintLength() {
		System.out.println("Scrum Master: Setting Length Of Sprints");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("sprintLength", "true", session);
		session.close();
	}

	// obligation for this role
	public static void splitGroomingAndPlanning() {
		System.out.println("Scrum Master: Splitting Grooming From Planning");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("planningSplit", "true", session);
		session.close();
	}

	// obligation for this role
	public static void setTaskMetric() {
		System.out.println("Scrum Master: Setting Task Metric");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("taskMetric", "true", session);
		session.close();
	}

	// obligation for this role
	public void startSprint() {
		System.out.println("Scrum Master: Starting Sprint");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("activeSprint", "true", session);
		Helper.updateBlackboardEntryRecord("checkRequirements", "false", session);
		session.close();
	}

	// obligation for this role
	public void keepInTime() {
		System.out.println("Scrum Master: Keeping Daily under fifteen minutes");

		Session session = HibernateUtil.getSessionfactory().openSession();
		Helper.updateBlackboardEntryRecord("underFifteen", "true", session);
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
		console = new InputConsole("Scrum Master Terminal", new ScrumMaster("Jack"));
		console.setVisible(running);

		System.out.println("Scrum Master joining workflow");
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
