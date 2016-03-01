package main.norms;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import main.database.GenericDaoImpl;
import main.database.SessionUtil;
import main.database.Symbol;

import org.hibernate.Session;

public class ConditionEvaluator {

	public static String processConditions(String conditions) {
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
			Session session = SessionUtil.getINSTANCE();
			GenericDaoImpl<Symbol> symbolDao = new GenericDaoImpl<Symbol>(session, Symbol.class);
			SessionUtil.beginTransaction();
			Symbol s = symbolDao.findBySymbolName(variable);
			SessionUtil.commitTransaction();

			conditions = conditions.replaceFirst(variable, s.getCurrentValue());
		}

		return conditions;
	}

	// use JavaScript engine to evaluate the string expression
	public static Boolean evaluate(String expression) {
		if (expression == null || expression.equals("")) {
			return null;
		}
		try {
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine scriptEngine = sem.getEngineByName("JavaScript");
			return (Boolean) scriptEngine.eval(expression);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
}
