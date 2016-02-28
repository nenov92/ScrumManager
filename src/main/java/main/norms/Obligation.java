package main.norms;

import main.Role;

public class Obligation {

	private Role roleId;
	private ActionFunction actionFunction;
	private String activationCondition;
	private String expriationCondition;
	private String obligationFulfilledResult;
	private String obligationNotFulfilledResult;

	public Obligation() {
	}

	public Obligation(Role roleId, ActionFunction actionFunction, String activationCondition, String expriationCondition,
			String obligationFulfilledResult, String obligationNotFulfilledResult) {
		this.roleId = roleId;
		this.actionFunction = actionFunction;
		this.activationCondition = activationCondition;
		this.expriationCondition = expriationCondition;
		this.obligationFulfilledResult = obligationFulfilledResult;
		this.obligationNotFulfilledResult = obligationNotFulfilledResult;
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

	public String getObligationFulfilledResult() {
		return obligationFulfilledResult;
	}

	public void setObligationFulfilledResult(String obligationFulfilledResult) {
		this.obligationFulfilledResult = obligationFulfilledResult;
	}

	public String getObligationNotFulfilledResult() {
		return obligationNotFulfilledResult;
	}

	public void setObligationNotFulfilledResult(String obligationNotFulfilledResult) {
		this.obligationNotFulfilledResult = obligationNotFulfilledResult;
	}

	@Override
	public String toString() {
		return "Obligation [roleId: " + roleId + ", actionFunction: " + actionFunction.getName() + ", activationCondition: " + activationCondition + ", expriationCondition: " + expriationCondition + ", obligationFulfilledResult: " + obligationFulfilledResult + ", obligationNotFulfilledResult: " + obligationNotFulfilledResult + "]";
	}

}
