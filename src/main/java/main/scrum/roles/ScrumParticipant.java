package main.scrum.roles;

/**
 * @author Miroslav Nenov
 * all Scrum roles inherit this class
 * used for easier integration with the personal user console
 */
public class ScrumParticipant {
	private Role role;

	// empty constructor
	public ScrumParticipant() {
	}

	public ScrumParticipant(Role role) {
		this.setRole(role);
	}

	/*
	 * getters and setters
	 */
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
