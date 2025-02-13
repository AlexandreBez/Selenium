package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test_cases.hands_on;

@RunWith(Suite.class)
@SuiteClasses({
	hands_on.class
})
public class HandsOnSuite {

}
