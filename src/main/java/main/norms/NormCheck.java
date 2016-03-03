package main.norms;

import java.util.Set;

import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

public class NormCheck implements Runnable {

	private static Set<ScrumParticipant> participants;
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
		while (running) {
			checkNorms();
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

	public static void checkObligations(Norm norm) {
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpriationCondition()))) {

				System.out.println("Obligation activated: " + obligation);

				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledResult()))) {
					System.out.println("Obligation fulfilled");
				} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledResult()))) {
					System.out.println("Obligation not fulfilled");
				}
			}
		}

	}

	public static void checkNorms() {
		ActionFunction function = new ActionFunction("startSprint", new String[] {});
		ActionFunction function2 = new ActionFunction("assignTask", new String[] {});
		Obligation obligation = new Obligation(Role.PRODUCT_OWNER, function, "checkRequirements == true && activeSprint == false && productTimeFrame > 0", "checkRequirements == false", "groomingSession == true && activeSprint == true && checkRequirements == false", "groomingSession == false");
		Obligation obligation1 = new Obligation(Role.SCRUM_MASTER, function2, "task1Assignees == 0 && planningSession == true", "planningSession == false", "task1Assignees > 0", "task1Assignees == 0");
		Prohibition prohibition = new Prohibition(Role.SCRUM_MASTER, function2, "task1Assignees == 1 && planningSession == true", "planningSession == false");

		Norm norm = new Norm();
		norm.addObligation(obligation1);
		norm.addObligation(obligation);
		norm.addProhibition(prohibition);
		checkObligations(norm);
	}

}
