package main.norms;

import java.util.HashSet;
import java.util.Set;

import main.Helper;
import main.scrum.roles.Role;

public class NormCheck implements Runnable {

	private static Set<Obligation> activeObligations;
	private static Set<Prohibition> activeProhibitions;
	private volatile boolean running = true;

	public void terminate() {
		running = false;
	}

	public NormCheck() {
	}

	@Override
	public void run() {
		System.out.println("Norm Check engine is running");

		activeObligations = new HashSet<Obligation>();
		setActiveProhibitions(new HashSet<Prohibition>());
		Norm norm = Helper.loadNorms();

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

	public static Set<Obligation> getActiveObligations() {
		return activeObligations;
	}

	public static void setActiveObligations(Set<Obligation> activeObligations) {
		NormCheck.activeObligations = activeObligations;
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

	public static void setActiveProhibitions(Set<Prohibition> activeProhibitions) {
		NormCheck.activeProhibitions = activeProhibitions;
	}

	public static void addActiveProhibition(Prohibition activeProhibition) {
		activeProhibitions.add(activeProhibition);
	}

	public static void deleteActiveProhibition(Prohibition activeProhibition) {
		activeProhibitions.remove(activeProhibition);
	}

	public static void activateObligations(Norm norm) {
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpirationCondition())) && !getActiveObligations().contains(obligation)) {

				System.out.println("Obligation activated: " + obligation.getRoleId() + " has to perform action " + obligation.getActionFunction());
				addActiveObligation(obligation);
			}
		}
	}

	public static void checkObligations(Norm norm) {
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledCondition())) && getActiveObligations().contains(obligation)) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has been fulfilled");
				deleteActiveObligation(obligation);
			} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledCondition()))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction() + " has NOT been fulfilled");
			}
		}
	}

	public static void activateProhibitions(Norm norm) {
		for (Prohibition prohibition : norm.getProhibitions()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition()))) {
				System.out.println("Prohibition activated: " + prohibition.getRoleId() + " is prohibited to perform " + prohibition.getPerform());
				addActiveProhibition(prohibition);
			} else if ((ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition())) == false ||
					ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpirationCondition()))) && getActiveProhibitions().contains(prohibition)) {
				deleteActiveProhibition(prohibition);
			}
		}
	}

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
