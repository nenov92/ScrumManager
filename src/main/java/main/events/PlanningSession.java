package main.events;

import java.util.logging.Logger;

import main.Constants;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PlanningSession implements JavaDelegate {
	private final static Logger LOGGER = Logger.getLogger(Constants.LOGGER);

	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("THIRD STEP");
		Thread.sleep(1000);
	}
}