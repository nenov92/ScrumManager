package main.norms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import main.Role;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.ScrumParticipant;

//																				activation condition 
//obligation(ProductOwner, startSprint(ProductId, ScrumId, previousSprintId), checkRequ = true AND activeSprint == false AND productTimeFrame > 0, checkReq = false, activeSprint==true)
public class NormChecker {
	private static ProductOwner p = new ProductOwner("Jack");
	private static Method method;
	private static Set<ScrumParticipant> participants = new HashSet<ScrumParticipant>();

	public static void checkNorms(Norm norm, Set<ScrumParticipant> participants) {
		for (Obligation obligation : norm.getObligations()) {
			if (ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getActivationCondition())) == true &&
					ConditionEvaluator.evaluate(ConditionEvaluator.processConditions(obligation.getExpriationCondition())) == false) {

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

								method = p.getClass().getMethod(obligation.getActionFunction().getName(), parameterTypes);
								try {
									System.out.println("Action function triggered: " + obligation.getActionFunction().getName());
									method.invoke(p, (Object[]) obligation.getActionFunction().getParameters());
								} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
									e.printStackTrace();
								}
							} else {
								method = p.getClass().getMethod(obligation.getActionFunction().getName(), (Class<?>[]) null);
								try {
									System.out.println("Action function triggered: " + obligation.getActionFunction().getName());
									method.invoke(p);
								} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
									e.printStackTrace();
								}
							}
						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						}

					}
				}

			}
		}
	}

	public static void temp() {
		ActionFunction function = new ActionFunction("startSprint", new String[] {});
		Obligation obligation = new Obligation(Role.PRODUCT_OWNER, function, "checkRequirements == true && activeSprint == false && productTimeFrame > 0", "checkRequirements == false", "groomingSession = true", "null");
		Norm norm = new Norm();
		norm.addObligation(obligation);
		participants.add(p);
		checkNorms(norm, participants);
	}
}
