package main.scrum.roles;

import main.Role;

public class ProductOwner extends ScrumParticipant {
	private static Role role = Role.PRODUCT_OWNER;
	private String name;

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
