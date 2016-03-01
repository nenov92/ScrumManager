package main.norms;

import main.scrum.roles.Role;

public class Obligation {

	private Role roleId;
	private ActionFunction actionFunction;
	private String activationCondition;
	private String expriationCondition;
	private String fulfilledResult;
	private String notFulfilledResult;

	public Obligation() {
	}

	public Obligation(Role roleId, ActionFunction actionFunction, String activationCondition, String expriationCondition,
			String fulfilledResult, String notFulfilledResult) {
		this.roleId = roleId;
		this.actionFunction = actionFunction;
		this.activationCondition = activationCondition;
		this.expriationCondition = expriationCondition;
		this.fulfilledResult = fulfilledResult;
		this.notFulfilledResult = notFulfilledResult;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public ActionFunction getActionFunction() {
		return actionFunction;
	}

	public void setActionFunction(ActionFunction actionFunction) {
		this.actionFunction = actionFunction;
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

	public String getFulfilledResult() {
		return fulfilledResult;
	}

	public void setFulfilledResult(String fulfilledResult) {
		this.fulfilledResult = fulfilledResult;
	}

	public String getNotFulfilledResult() {
		return notFulfilledResult;
	}

	public void setNotFulfilledResult(String notFulfilledResult) {
		this.notFulfilledResult = notFulfilledResult;
	}

	@Override
	public String toString() {
		return "Obligation [roleId: " + roleId + ", actionFunction: " + actionFunction.getName() + ", activationCondition: " + activationCondition + ", expriationCondition: " + expriationCondition + ", fulfilledResult: " + fulfilledResult + ", notFulfilledResult: " + notFulfilledResult + "]";
	}

}
