package test;
import main.norms.NormConditionsEvaluator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class General {

	@Test
	public void evaluatorTest() {
		String expression = "true == true && 5 > 3 || true == false";
		boolean result = NormConditionsEvaluator.evaluate(expression);
		assertTrue("Error", result);
		
		expression = "false == true";
		result = NormConditionsEvaluator.evaluate(expression);
		assertFalse("Error", result);
		
		expression = "false == !true";
		result = NormConditionsEvaluator.evaluate(expression);
		assertTrue("Error", result);
	}
}
