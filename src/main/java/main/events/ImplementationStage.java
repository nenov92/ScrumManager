package main.events;

import java.util.logging.Logger;

import main.Constants;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ImplementationStage implements JavaDelegate {
	private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("FOURTH STEP: " + Constants.counter);
		Thread.sleep(1000);
		Constants.counter += 1;
		if (Constants.counter > 1) {
			LOGGER.info("==================================HERE");
			execution.getProcessInstance().setVariable("implement", false);
		} else {
			LOGGER.info("==================================THERE");
			execution.getProcessInstance().setVariable("implement", true);
		}

	}
}