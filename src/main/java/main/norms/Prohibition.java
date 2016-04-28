package main.norms;

import main.scrum.roles.Role;


/**
 * @author Miroslav Nenov
 * norm object of type prohibition
 */
public class Prohibition {

	private int id;
	private Role roleId;
	private String actionName;
	private String activationCondition;
	private String expirationCondition;
	private String violatedCondition;

	// empty constructor 
	public Prohibition() {
	}

	public Prohibition(int id, Role roleId, String actionName, String activationCondition, String expirationCondition, String violatedCondition) {
		this.id = id;
		this.roleId = roleId;
		this.actionName = actionName;
		this.activationCondition = activationCondition;
		this.expirationCondition = expirationCondition;
		this.violatedCondition = violatedCondition;
	}

	/**
	 * default getters and setters below 
	 */
	
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

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
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

	public String getViolatedCondition() {
		return violatedCondition;
	}

	public void setViolatedCondition(String violatedCondition) {
		this.violatedCondition = violatedCondition;
	}

	/** 
	 * default object equals function overridden 
	 */
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

	/** 
	 * default hashCode function overridden
	 * uniqueness guaranteed by using a combination of a prime number and unique id   
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = (int) (PRIME + this.id);
		return result;
	}
	
	/** 
	 * default toString function overridden
	 */
	@Override
	public String toString() {
		return "Prohibition [roleId: " + roleId + ", actionName: " + actionName + ", activationCondition: " + activationCondition + ", expriationCondition: " + expirationCondition + ", violatedCondition: " + violatedCondition + "]";
	}

}
