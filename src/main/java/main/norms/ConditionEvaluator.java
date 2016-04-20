package main.norms;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import main.Helper;
import main.database.BlackboardEntry;
import main.database.GenericDaoImpl;
import main.database.SessionUtil;

import org.hibernate.Session;

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
public class ConditionEvaluator {

	/**
	 * @param conditions
	 * @return the same string of conditions, but instead the names of the parameters
	 * 		   are substituted with their real values taken from the database
	 */
	public static String processConditions(String conditions) {
		
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
			Session session = SessionUtil.getINSTANCE();
			GenericDaoImpl<BlackboardEntry> symbolDao = new GenericDaoImpl<BlackboardEntry>(session, BlackboardEntry.class);
			SessionUtil.beginTransaction();
			BlackboardEntry s = symbolDao.findByBlackboardEntryName(variable);
			SessionUtil.commitTransaction();

			// substitute the variable name with a real value
			conditions = conditions.replaceFirst(variable, s.getCurrentValue());
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
