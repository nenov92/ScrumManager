package main.norms;

import main.scrum.roles.Role;

/**
 * The MIT License
 * 
 * Copyright 2016 Miroslav Nenov <m.nenov92 at gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class Prohibition {

	private int id;
	private Role roleId;
	private String actionName;
	private String activationCondition;
	private String expirationCondition;

	// empty constructor 
	public Prohibition() {
	}

	public Prohibition(int id, Role roleId, String actionName, String activationCondition, String expirationCondition) {
		this.id = id;
		this.roleId = roleId;
		this.actionName = actionName;
		this.activationCondition = activationCondition;
		this.expirationCondition = expirationCondition;
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
		return "Prohibition [roleId: " + roleId + ", actionName: " + actionName + ", activationCondition: " + activationCondition + ", expriationCondition: " + expirationCondition + "]";
	}

}
