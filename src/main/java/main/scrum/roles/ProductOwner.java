package main.scrum.roles;

import main.Helper;
import main.gui.InputConsole;

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

	public void startSprint() {
		System.out.println("ProductOwner: Starting Sprint");

		Helper.updateSymbolRecord("groomingSession", "true");
		Helper.updateSymbolRecord("activeSprint", "true");
		Helper.updateSymbolRecord("checkRequirements", "false");
	}

	public void closeConsole() {
		this.running = false;
	}

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
