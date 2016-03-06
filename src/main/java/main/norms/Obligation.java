package main.norms;

import main.scrum.roles.Role;

public class Obligation {

	private int id;
	private Role roleId;
	private String actionFunction;
	private String activationCondition;
	private String expirationCondition;
	private String fulfilledCondition;
	private String notFulfilledCondition;

	public Obligation() {
	}

	public Obligation(int id, Role roleId, String actionFunction, String activationCondition, String expirationCondition,
			String fulfilledCondition, String notFulfilledCondition) {
		this.id = id;
		this.roleId = roleId;
		this.actionFunction = actionFunction;
		this.activationCondition = activationCondition;
		this.expirationCondition = expirationCondition;
		this.fulfilledCondition = fulfilledCondition;
		this.notFulfilledCondition = notFulfilledCondition;
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

	public String getActionFunction() {
		return actionFunction;
	}

	public void setActionFunction(String actionFunction) {
		this.actionFunction = actionFunction;
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

	public void setExpirationCondition(String expirationCondition) {
		this.expirationCondition = expirationCondition;
	}

	public String getFulfilledCondition() {
		return fulfilledCondition;
	}

	public void setFulfilledCondition(String fulfilledCondition) {
		this.fulfilledCondition = fulfilledCondition;
	}

	public String getNotFulfilledCondition() {
		return notFulfilledCondition;
	}

	public void setNotFulfilledCondition(String notFulfilledCondition) {
		this.notFulfilledCondition = notFulfilledCondition;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Obligation) {
			Obligation other = (Obligation) o;
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
		return "Obligation [id: " + id + ", roleId: " + roleId + ", actionFunction: " + actionFunction + ", activationCondition: " + activationCondition + ", expriationCondition: " + expirationCondition + ", fulfilledResult: " + fulfilledCondition + ", notFulfilledResult: " + notFulfilledCondition + "]";
	}

}
