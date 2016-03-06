package main.norms;

import main.scrum.roles.Role;

public class Prohibition {

	private int id;
	private Role roleId;
	private String perform;
	private String activationCondition;
	private String expirationCondition;

	public Prohibition() {
	}

	public Prohibition(int id, Role roleId, String perform, String activationCondition, String expirationCondition) {
		this.id = id;
		this.roleId = roleId;
		this.perform = perform;
		this.activationCondition = activationCondition;
		this.expirationCondition = expirationCondition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public String getPerform() {
		return perform;
	}

	public void setPerform(String perform) {
		this.perform = perform;
	}

	public String getActivationCondition() {
		return activationCondition;
	}

	public void setActivationCondition(String activationCondition) {
		this.activationCondition = activationCondition;
	}

	public String getExpirationCondition() {
		return expirationCondition;
	}

	public void setExpriationCondition(String expirationCondition) {
		this.expirationCondition = expirationCondition;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Prohibition) {
			Prohibition other = (Prohibition) o;
			if (this.getId() == other.getId()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = (int) (PRIME + this.id);
		return result;
	}
	
	@Override
	public String toString() {
		return "Prohibition [roleId: " + roleId + ", perform: " + perform + ", activationCondition: " + activationCondition + ", expriationCondition: " + expirationCondition + "]";
	}

}
