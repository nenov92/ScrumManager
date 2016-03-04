package main.scrum.roles;

import main.Helper;
import main.gui.InputConsole;
import main.norms.NormCheck;
import main.norms.Obligation;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: ");
		sb.append(getName());
		sb.append("; Role: ");
		sb.append(getRole());
		return sb.toString();
	}

	@Override
	public void run() {
		console = new InputConsole("SM Terminal", new ScrumMaster("Jack"));
		console.setVisible(running);

		System.out.println("Hello, I am SM");
		while (running) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Helper.isObligationActive()) {
				console.getObList().removeAllElements();
				for (Obligation o : NormCheck.getActiveObligations()) {
					if (o.getRoleId() == getRole()) {
						console.getObList().addElement(o.getActionFunction().getName());
					}
				}
			} else {
				if (console.getObList().size() > 0) {
					console.getObList().removeAllElements();
				}
			}
		}
	}

	public void closeConsole() {
		this.running = false;
	}
}
