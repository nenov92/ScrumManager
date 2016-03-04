package main.norms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import main.Helper;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.Role;
import main.scrum.roles.ScrumMaster;
import main.scrum.roles.ScrumParticipant;

public class NormChecker {
	
	public static void checkObligations(Norm norm, Set<ScrumParticipant> participants) {
		Method method;
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpriationCondition()))) {

				System.out.println("Obligation activated: " + obligation);

				for (ScrumParticipant participant : participants) {
					// if the obligaion role matches the participant's role
					if (participant.getRole().equals(obligation.getRoleId())) {
						// get instance of the role and call the action function
						checkProhibitions(norm, participants);
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
	
	public static void checkProhibitions(Norm norm, Set<ScrumParticipant> participants) {
		@SuppressWarnings("unused")
		Method method;
		for (Prohibition prohibition : norm.getProhibitions()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getActivationCondition())) &&
					!ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(prohibition.getExpriationCondition()))) {
				System.out.println("Prohibition activated: " + prohibition);

				for (ScrumParticipant participant : participants) {
					if (participant.getRole().equals(prohibition.getRoleId())) {
						try {
							method = participant.getClass().getMethod(prohibition.getPerform().getName(), (Class<?>[]) null);
							try {
								System.out.println("Perform of function: " + prohibition.getPerform().getName() + " prohibited");
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							}
						} catch (NoSuchMethodException | SecurityException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void checkNorms() {
		Set<ScrumParticipant> participants = new HashSet<ScrumParticipant>();
		ProductOwner p = new ProductOwner("Jack");
		ScrumMaster s = new ScrumMaster("Mike");
		participants.add(p);
		participants.add(s);
		
		ActionFunction function = new ActionFunction("startSprint", new String[] {});
		ActionFunction function2 = new ActionFunction("assignTask", new String[] {});
		Obligation obligation = new Obligation(Role.PRODUCT_OWNER, function, "checkRequirements == true && activeSprint == false && productTimeFrame > 0", "checkRequirements == false", "groomingSession == true && activeSprint == true && checkRequirements == false", "");
		Obligation obligation1 = new Obligation(Role.SCRUM_MASTER, function2, "task1Assignees == 0 && planningSession == true", "planningSession == false", "task1Assignees > 0", "task1Assignees == 0");
		Prohibition prohibition = new Prohibition(Role.SCRUM_MASTER, function2, "task1Assignees == 1 && planningSession == true", "planningSession == false");
		
		Norm norm = new Norm();
		norm.addObligation(obligation1);
		norm.addObligation(obligation);
		norm.addProhibition(prohibition);
		checkObligations(norm, participants);
	}

	public static void main(String[] args) {
//		 System.setSecurityManager(new SecurityManager() {
//	            @Override
//	            public void checkPermission(Permission perm) {
//	                if (perm instanceof ReflectPermission && "suppressAccessChecks".equals(perm.getName())) {
//	                }
//	            }
//	        });
		
		checkNorms();
		Helper.refreshDatabase();
	}
}
