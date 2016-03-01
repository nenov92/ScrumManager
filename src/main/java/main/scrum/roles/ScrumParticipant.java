package main.scrum.roles;

public class ScrumParticipant {
	private Role role;

	public ScrumParticipant() {
	}

	public ScrumParticipant(Role role) {
		this.setRole(role);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
