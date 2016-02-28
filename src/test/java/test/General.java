package test;
import main.norms.ConditionEvaluator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class General {

	@Test
	public void evaluatorTest() {
		String expression = "true == true && 5 > 3 || true == false";
		boolean result = ConditionEvaluator.evaluate(expression);
		assertTrue("Error", result);
		
		expression = "false == true";
		result = ConditionEvaluator.evaluate(expression);
		assertFalse("Error", result);
		
		expression = "false == !true";
		result = ConditionEvaluator.evaluate(expression);
		assertTrue("Error", result);
	}
}
