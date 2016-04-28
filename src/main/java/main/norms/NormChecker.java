package main.norms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import main.Constants;
import main.Helper;
import main.database.HibernateUtil;
import main.scrum.roles.Role;


/**
 * @author Miroslav Nenov
 * the class which controls compliance with norms,
 * concurrently running on a separate thread
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
			Session session = HibernateUtil.getSessionfactory().openSession();
			
			activateObligations(norm, session);
			activateProhibitions(norm, session);
			
			try {
				Thread.sleep(Constants.SLEEP_MED_LOW);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			checkObligations(session);
			session.close();
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
	private static void activateObligations(Norm norm, Session session) {
		// check if norm has any obligations loaded
		if (norm.getObligations().size() > 0) {
			// for each obligation parsed in the norm file
			for (Obligation obligation : norm.getObligations()) {
				
				// if activation condition is TRUE and expiration condition is FALSE and this obligation is not already activated 
				// and there is no prohibition for the role of the obligation to perform the same action
				// then activate this obligation
				if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition(), session)) &&
						!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpirationCondition(), session)) && 
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
	private static void activateProhibitions(Norm norm, Session session) {
		// for each prohibition parsed in the norm file
		for (Prohibition prohibition : norm.getProhibitions()) {
			// if activation condition is TRUE and expiration condition is FALSE activate prohibition
			if (!getActiveProhibitions().contains(prohibition) && ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition(), session)) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition(), session))) {
				
				System.out.println("Prohibition activated: " + prohibition.getRoleId() + " is prohibited to perform " + prohibition.getActionName());
				addActiveProhibition(prohibition);
				// if activation condition is FALSE and expiration condition is TRUE  and the prohibition is part of the set of active prohibitions, then deactivate this prohibition	
			} else if (getActiveProhibitions().contains(prohibition) && (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition(), session)) == false ||
					ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition(), session))) && 
					ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getViolatedCondition(), session)) == false) {
				
				System.out.println("Prohibition deactivated: " + prohibition.getRoleId() + " is no longer prohibited to perform " + prohibition.getActionName());
				deleteActiveProhibition(prohibition);
			}
		}
	}

	/**
	 * this method is used to check if active obligations have been fulfilled; periodically run at a given time quantum   
	 */
	private static void checkObligations(Session session) {
		Obligation obligation;
		// iterate through all active obligations and check if it has been fulfilled  
		Iterator<Obligation> iterator = getActiveObligations().iterator();
		while(iterator.hasNext()){
			obligation = iterator.next();
			// if it has been fulfilled, then deactivate it, otherwise inform that it is still active
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledCondition(), session))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has been fulfilled");

				iterator.remove(); // solves concurrent modification exception
			} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledCondition(), session))) {
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
