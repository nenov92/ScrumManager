package main.scrum.roles;

import main.Helper;
import main.gui.InputConsole;

public class ScrumMaster extends ScrumParticipant implements Runnable {
	private static Role role = Role.SCRUM_MASTER;
	private String name;
	private InputConsole console;
	private volatile boolean running = true;

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

	public static void assignTask() {
		Helper.incrementSymbolRecord("task1Assignees");
	}

	public void closeConsole() {
		this.running = false;
	}

	@Override
	public void run() {
		console = new InputConsole("Scrum Master Terminal", new ScrumMaster("Jack"));
		console.setVisible(running);

		System.out.println("Scrum Master joining workflow");
		while (running) {
			Helper.addActiveNormsToConsole(console, getRole());
		}
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
