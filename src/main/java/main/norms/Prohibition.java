package main.norms;

import main.scrum.roles.Role;

public class Prohibition {
	private Role roleId;
	private ActionFunction perform;
	private String activationCondition;
	private String expriationCondition;

	public Prohibition() {
	}

	public Prohibition(Role roleId, ActionFunction perform, String activationCondition, String expriationCondition) {
		this.roleId = roleId;
		this.perform = perform;
		this.activationCondition = activationCondition;
		this.expriationCondition = expriationCondition;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public ActionFunction getPerform() {
		return perform;
	}

	public void setPerform(ActionFunction perform) {
		this.perform = perform;
	}

	public String getActivationCondition() {
		return activationCondition;
	}

	public void setActivationCondition(String activationCondition) {
		this.activationCondition = activationCondition;
	}

	public String getExpriationCondition() {
		return expriationCondition;
	}

	public void setExpriationCondition(String expriationCondition) {
		this.expriationCondition = expriationCondition;
	}

	@Override
	public String toString() {
		return "Prohibition [roleId: " + roleId + ", perform: " + perform + ", activationCondition: " + activationCondition + ", expriationCondition: " + expriationCondition + "]";
	}
	
	
}
