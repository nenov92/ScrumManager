package main.norms;

import java.util.HashSet;
import java.util.Set;

import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

public class NormCheck implements Runnable {

	private static Set<ScrumParticipant> participants;
	private static Set<Obligation> activeObligations;
	private volatile boolean running = true;

	public void terminate() {
		running = false;
	}

	public NormCheck() {
	}

	public NormCheck(Set<ScrumParticipant> participants) {
		NormCheck.participants = participants;
	}

	@Override
	public void run() {
		System.out.println("NormChecker is running");
		activeObligations = new HashSet<Obligation>();
		Norm norm = loadNorms();
		while (running) {
			activateObligations(norm);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			checkObligations(norm);
		}
	}

	public static Set<ScrumParticipant> getParticipants() {
		return participants;
	}

	public static void setParticipants(Set<ScrumParticipant> participants) {
		NormCheck.participants = participants;
	}

	public static void addParticipant(ScrumParticipant participant) {
		participants.add(participant);
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

	public static void activateObligations(Norm norm) {
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpriationCondition()))) {

				System.out.println("Obligation activated: " + obligation.getRoleId() + " has to perform action " + obligation.getActionFunction().getName());
				addActiveObligation(obligation);
			}
		}
	}
	
	public static void checkObligations(Norm norm) {
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledResult())) && getActiveObligations().contains(obligation)) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction().getName() + " has been fulfilled");
				deleteActiveObligation(obligation);
			} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledResult()))) {
				System.out.println("Obligation for " + obligation.getRoleId() + " to perform action " + obligation.getActionFunction().getName() + " has NOT been fulfilled");
			}
		}
	}

	public static Norm loadNorms() {
		ActionFunction function = new ActionFunction("startSprint", new String[] {});
		ActionFunction function2 = new ActionFunction("assignTask", new String[] {});
		Obligation obligation = new Obligation(1, Role.PRODUCT_OWNER, function, "checkRequirements == true && activeSprint == false && productTimeFrame > 0", "checkRequirements == false", "groomingSession == true && activeSprint == true && checkRequirements == false", "groomingSession == false");
		Obligation obligation1 = new Obligation(2, Role.SCRUM_MASTER, function2, "task1Assignees == 0 && planningSession == true", "planningSession == false", "task1Assignees > 0", "task1Assignees == 0");
		Prohibition prohibition = new Prohibition(Role.SCRUM_MASTER, function2, "task1Assignees == 1 && planningSession == true", "planningSession == false");

		Norm norm = new Norm();
		norm.addObligation(obligation1);
		norm.addObligation(obligation);
		norm.addProhibition(prohibition);
		
		return norm;
	}

}
