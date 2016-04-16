package main.norms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import main.Helper;
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
public class NormCheck implements Runnable {

	private static Set<Obligation> activeObligations;
	private static Set<Prohibition> activeProhibitions;
	
	// used to control the life scope of the thread
	private volatile boolean running = true;

	// empty constructor
	public NormCheck() {
	}

	@Override
	public void run() {
		System.out.println("Norm Check engine is running");

		activeObligations = new HashSet<Obligation>();
		activeProhibitions = new HashSet<Prohibition>();

		// get obligations and prohibitions stored in the norms.conf file and
		// add them in a new Norm object
		Norm norm = Helper.loadNorms();

		// until the tread is not suspended, dynamically assign obligations and prohibitions
		// after a constant time check if the obligations have been achieved
		while (running) {
			activateObligations(norm);
			activateProhibitions(norm);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			checkObligations(norm);
		}
	}
	
	// function that stops the thread from running 
	public void terminate() {
		running = false;
	}

	public static Set<Obligation> getActiveObligations() {
		return activeObligations;
	}
	
	public static void addActiveObligation(Obligation activeObligation) {
		activeObligations.add(activeObligation);
	}

	public static void deleteActiveObligation(Obligation activeObligation) {
		activeObligations.remove(activeObligation);
	}

	public static Set<Prohibition> getActiveProhibitions() {
		return activeProhibitions;
	}

	public static void addActiveProhibition(Prohibition activeProhibition) {
		activeProhibitions.add(activeProhibition);
	}

	public static void deleteActiveProhibition(Prohibition activeProhibition) {
		activeProhibitions.remove(activeProhibition);
	}
	
	/**
	 * @param norm 
	 */
	private static void activateObligations(Norm norm) {
		// for each obligation parsed in the norm file
		for (Obligation obligation : norm.getObligations()) {
			
			// if activation condition is TRUE and expiration condition is FALSE and this obligation is not already activated 
			// and there is no prohibition for the role of the obligation to perform the same action
			// then activate this obligation
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpirationCondition())) && 
					!getActiveObligations().contains(obligation) && !isActionProhibited(obligation.getRoleId(), obligation.getActionFunction())) {

				System.out.println("Obligation activated: " + obligation.getRoleId() + " has to perform action " + obligation.getActionFunction());
				addActiveObligation(obligation);
			}
		}
	}

	/**
	 * @param norm
	 */
	private static void activateProhibitions(Norm norm) {
		// for each prohibition parsed in the norm file
		for (Prohibition prohibition : norm.getProhibitions()) {
			// if activation condition is TRUE and expiration condition is FALSE activate prohibition
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition()))) {
				
				System.out.println("Prohibition activated: " + prohibition.getRoleId() + " is prohibited to perform " + prohibition.getActionName());
				addActiveProhibition(prohibition);
				// if activation condition is FALSE and expiration condition is TRUE  and the prohibition is part of the set of active prohibitions, then deactivate this prohibition	
			} else if ((ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition())) == false ||
					ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition()))) && getActiveProhibitions().contains(prohibition)) {
				deleteActiveProhibition(prohibition);
			}
		}
	}

	/**
	 * @param norm
	 */
	private static void checkObligations(Norm norm) {
		Obligation obligation;
		// iterate through all active obligations and check if it has been fulfilled  
		Iterator<Obligation> iterator = getActiveObligations().iterator();
		// for (Obligation obligation : getActiveObligations()) {
		while(iterator.hasNext()){
			obligation = iterator.next();
			// if it has been fulfilled, then deactivate it, otherwise inform that it is still active
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledCondition()))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has been fulfilled");
				//deleteActiveObligation(obligation);
				iterator.remove(); // solves concurrent modification exception
			} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledCondition()))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has NOT been fulfilled");
			}
		}
	}
	
	/**
	 * @param role
	 * @param actionName
	 * @return boolean; true if there is a prohibition for a role to perform this action, false otherwise  
	 */
	private static boolean isActionProhibited(Role role, String actionName) {
		for (Prohibition prohibition : getActiveProhibitions()) {
			if (prohibition.getRoleId() == role && prohibition.getActionName().equals(actionName)) {
				return true;
			}
		}
		return false;
	}

	// TODO: delete
	public static Norm loadNorms() {
		Obligation obligation = new Obligation(1, Role.PRODUCT_OWNER, "startSprint", "checkRequirements == true && activeSprint == false && productTimeFrame > 0", "checkRequirements == false", "groomingSession == true && activeSprint == true && checkRequirements == false", "groomingSession == false");
		Obligation obligation1 = new Obligation(2, Role.SCRUM_MASTER, "assignTask", "task1Assignees == 0 && planningSession == true", "planningSession == false", "task1Assignees > 0", "task1Assignees == 0");
		Prohibition prohibition = new Prohibition(1, Role.SCRUM_MASTER, "assignTask", "task1Assignees == 1 && planningSession == true", "planningSession == false");

		Norm norm = new Norm();
		norm.addObligation(obligation1);
		norm.addObligation(obligation);
		norm.addProhibition(prohibition);

		return norm;
	}

}
