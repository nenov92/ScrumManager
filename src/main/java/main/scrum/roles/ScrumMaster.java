package main.scrum.roles;

import main.Helper;
import main.gui.InputConsole;

public class ScrumMaster extends ScrumParticipant implements Runnable {
	private static Role role = Role.SCRUM_MASTER;
	private String name;
	private InputConsole console;
	private volatile boolean showConsole = true;

	public ScrumMaster() {
	}

	public ScrumMaster(String name) {
		super(role);
		this.setName(name);
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
		console.setVisible(showConsole);
		
		if(showConsole == false){
			System.out.println("ShouldClose");
		}
		
		System.out.println("Hello, I am SM");
	}

	public void closeConsole() {
		this.showConsole = false;
	}
}
