package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Miroslav Nenov
 * This is the main testing class, it runs the tests in all classes listed below
 */
@RunWith(Suite.class)
@SuiteClasses({ NormCheckerTests.class, HelperTests.class, ScrumRolesTests.class, DatabaseOperationTests.class })
public class AllUnitTests {

}
