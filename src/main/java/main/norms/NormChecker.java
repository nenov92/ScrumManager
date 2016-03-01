package main.norms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import main.scrum.roles.ProductOwner;
import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

public class NormChecker {
	
	public static void checkNorms(Norm norm, Set<ScrumParticipant> participants) {
		Method method;
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpriationCondition()))) {

				System.out.println("Obligation activated: " + obligation);

				for (ScrumParticipant participant : participants) {
					// if the obligaion role matches the participant's role
					if (participant.getRole().equals(obligation.getRoleId())) {
						// get instance of the role and call the action function
						try {
							// check if the method to be called has any parameters and if so, call it with the given parameters; otherwise call it without any parameters
							if (obligation.getActionFunction().getParameters().length > 0) {
								@SuppressWarnings("rawtypes")
								Class[] parameterTypes = new Class[obligation.getActionFunction().getParameters().length];
								for (int i = 0; i < parameterTypes.length; i++) {
									parameterTypes[i] = String.class;
								}

								method = participant.getClass().getMethod(obligation.getActionFunction().getName(), parameterTypes);
								try {
									System.out.println("Action function triggered: " + obligation.getActionFunction().getName());
									method.invoke(participant, (Object[]) obligation.getActionFunction().getParameters());
								} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
									e.printStackTrace();
								}
							} else {
								method = participant.getClass().getMethod(obligation.getActionFunction().getName(), (Class<?>[]) null);
								try {
									System.out.println("Action function triggered: " + obligation.getActionFunction().getName());
									method.invoke(participant);
								} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
									e.printStackTrace();
								}
							}
						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						}
						
						// check the result of the action function of the obligation
						if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getFulfilledResult()))) {
							System.out.println("Obligation fulfilled");
						} else if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getNotFulfilledResult()))) {
							System.out.println("Obligation not fulfilled");
						}
					}
				}

			}
		}
	}

	public static void checkNorms() {
		Set<ScrumParticipant> participants = new HashSet<ScrumParticipant>();
		ProductOwner p = new ProductOwner("Jack");
		participants.add(p);
		ActionFunction function = new ActionFunction("startSprint", new String[] {});
		Obligation obligation = new Obligation(Role.PRODUCT_OWNER, function, "checkRequirements == true && activeSprint == false && productTimeFrame > 0", "checkRequirements == false", "groomingSession == true && activeSprint == true && checkRequirements == false", "");
		Norm norm = new Norm();
		norm.addObligation(obligation);
		checkNorms(norm, participants);
	}
}
