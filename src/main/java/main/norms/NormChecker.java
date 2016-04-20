package main.norms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import main.Constants;
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
public class NormChecker implements Runnable {

	private static Set<Obligation> activeObligations;
	private static Set<Prohibition> activeProhibitions;
	
	// used to control the life scope of the thread
	private volatile boolean running = true;

	private String fileLocation = Constants.NORMS_FILE_ON_SERVER;
	
	// empty constructor
	public NormChecker() {
	}

	// when created the constructor gets the file location of norms
	// the constructor mainly used for unit testing of this class 
	public NormChecker(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	@Override
	public void run() {
		System.out.println("Norm Check engine is running");

		activeObligations = new HashSet<Obligation>();
		activeProhibitions = new HashSet<Prohibition>();

		// get obligations and prohibitions stored in the norms.conf file and
		// add them in a new Norm object
		Norm norm = Helper.loadNorms(fileLocation);

		// until the tread is not suspended, dynamically assign obligations and prohibitions
		// after a constant time check if the obligations have been achieved
		while (running) {
			activateObligations(norm);
			activateProhibitions(norm);
			
			try {
				Thread.sleep(Constants.SLEEP_MED_LOW);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			checkObligations();
		}
	}
	
	// function that stops the thread from running 
	public void terminate() {
		running = false;
	}

	/**
	 * default getters and setters below 
	 */
	
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
		// check if norm has any obligations loaded
		if (norm.getObligations().size() > 0) {
			// for each obligation parsed in the norm file
			for (Obligation obligation : norm.getObligations()) {
				
				// if activation condition is TRUE and expiration condition is FALSE and this obligation is not already activated 
				// and there is no prohibition for the role of the obligation to perform the same action
				// then activate this obligation
				if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
						!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpirationCondition())) && 
						!getActiveObligations().contains(obligation) && !isActionProhibited(obligation.getRoleId(), obligation.getActionFunction(), getActiveProhibitions())) {
					
					System.out.println("Obligation activated: " + obligation.getRoleId() + " has to perform action " + obligation.getActionFunction());
					addActiveObligation(obligation);
				}
			}
		}
	}

	/**
	 * @param norm: norm holding prohibitions
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
			} else if (getActiveProhibitions().contains(prohibition) && (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition())) == false ||
					ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition())))) {
				deleteActiveProhibition(prohibition);
			}
		}
	}

	/**
	 * this method is used to check if active obligations have been fulfilled; periodically run at a given time quantum   
	 */
	private static void checkObligations() {
		Obligation obligation;
		// iterate through all active obligations and check if it has been fulfilled  
		Iterator<Obligation> iterator = getActiveObligations().iterator();
		while(iterator.hasNext()){
			obligation = iterator.next();
			// if it has been fulfilled, then deactivate it, otherwise inform that it is still active
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledCondition()))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has been fulfilled");

				iterator.remove(); // solves concurrent modification exception
			} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledCondition()))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has NOT been fulfilled");
			}
		}
	}
	
	/**
	 * @param role: the role of Scrum Participant; PRODUCT_OWNER, SCRUM_MASTER, DEV_TEAM 
	 * @param actionName: the name of the action, taken from a specified obligation
	 * @param prohibitions: the set of activated prohibitions
	 * @return boolean; true if there is a prohibition for a role to perform this action, false otherwise
	 * 
	 * Used to control precedence between deontic modalities; defined as public because it needs to be unit tested
	 */
	public static boolean isActionProhibited(Role role, String actionName, Set<Prohibition> prohibitions) {
		for (Prohibition prohibition : prohibitions) {
			if (prohibition.getRoleId() == role && prohibition.getActionName().equals(actionName)) {
				return true;
			}
		}
		return false;
	}

}
