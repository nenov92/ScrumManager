package main.scrum.roles;

import main.Helper;
import main.gui.InputConsole;
import main.norms.NormCheck;
import main.norms.Obligation;

public class ProductOwner extends ScrumParticipant implements Runnable {
	private static Role role = Role.PRODUCT_OWNER;
	private String name;
	private InputConsole console;
	private volatile boolean running = true;

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
		console = new InputConsole("PO Terminal", new ProductOwner("Sam"));
		console.setVisible(true);

		System.out.println("Hello, I am PO");
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
