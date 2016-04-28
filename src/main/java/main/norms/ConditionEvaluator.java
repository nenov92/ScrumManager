package main.norms;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import main.Helper;
import main.database.BlackboardEntry;
import main.database.GenericDaoImpl;

import org.hibernate.Session;


/**
 * @author Miroslav Nenov
 * Evaluates the truth value of conditional expressions
 * using JavaScript Engine
 */
public class ConditionEvaluator {

	/**
	 * @param conditions
	 * @return the same string of conditions, but instead the names of the parameters
	 * 		   are substituted with their real values taken from the database
	 */
	public static String processConditions(String conditions , Session session) {
		
		// mechanism to assure that only a valid conditions string will be processed 
		if (conditions == null || conditions.equals("")) {
			return null;
		}
		
		List<String> variables = new ArrayList<String>();

		// split to a tuples of three: <variable, operator, value> by && or ||
		String[] parsed = conditions.split("(&& )|(\\|\\| )");

		// put the variable names in a list
		for (int i = 0; i < parsed.length; i++) {
			variables.add(parsed[i].split(" ")[0]);
		}

		// for every variable name retrieve its value from the database and substitute the name with the actual value in the processed string
		for (String variable : variables) {
			GenericDaoImpl<BlackboardEntry> symbolDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
			session.beginTransaction();
			BlackboardEntry blackboardEntry = symbolDao.findByBlackboardEntryName(variable);
			session.getTransaction().commit();
			
			// substitute the variable name with a real value
			conditions = conditions.replaceFirst(variable, blackboardEntry.getCurrentValue());
		}

		return conditions;
	}

	/**
	 * @param expression
	 * @return boolean; use JavaScript engine to evaluate the string expression 
	 */
	public static Boolean evaluate(String expression) {
		// mechanism to assure that only a valid expression string will be processed 
		if (expression == null || expression.equals("")) {
			return null;
		}
		
		try {
			ScriptEngine scriptEngine = Helper.getScriptEngineManager().getEngineByName("JavaScript");
			return (Boolean) scriptEngine.eval(expression);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
}
