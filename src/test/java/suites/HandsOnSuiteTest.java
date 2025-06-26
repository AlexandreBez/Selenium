package suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test_cases.RegisterAndLoginForNewUsers;
import test_cases.UserAccountModifications;

/**
 * Suite class to run the test case class
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
@Suite(failIfNoTests = true)
@SelectClasses(value = {
    RegisterAndLoginForNewUsers.class,
    UserAccountModifications.class
})
public class HandsOnSuiteTest {
}
