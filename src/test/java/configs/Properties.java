package configs;

/**
 * Properties select for multiple options while running the test execution
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class Properties {
	
	/**
	 * Browser selection for WebDriver
	 * @since 1.0
	 */
	public static Browsers BROWSER = Browsers.CHROME;
	
	/**
	 * Amount of time per seconds before timeout the test case
	 * @since 1.0
	 */
	public static int AWAIT_TIME = 10;
	
	/**
	 * Turn on/off screenshot capture after every test run
	 * @since 1.0
	 */
	public static Boolean TAKE_SCREENSHOT = true;
	
}
