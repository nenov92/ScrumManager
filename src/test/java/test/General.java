package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import main.norms.ConditionEvaluator;
import main.norms.Norm;
import main.norms.Obligation;
import main.scrum.roles.ProductOwner;
import main.scrum.roles.Role;
import main.scrum.roles.ScrumParticipant;

import org.junit.Test;

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

	@Test
	public void normObligationTest() {
		Set<ScrumParticipant> participants = new HashSet<ScrumParticipant>();
		ProductOwner p = new ProductOwner("Jack");
		participants.add(p);
		
		Obligation obligation = new Obligation(10, Role.PRODUCT_OWNER, "startSprint", "condition == true && condition2 > 3 || condition3 == false", "condition == false", "condition == true", "");
		Norm norm = new Norm();
		norm.addObligation(obligation);
		
		//NormChecker.checkObligations(norm, participants);
	}
}
