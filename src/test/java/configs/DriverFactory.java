package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Factory of Drivers to start the WebDrivers and Threads
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class DriverFactory {

	/**
	 * Initialize the ThreadDriver that will maintain the WebDriver for parallelism test support
	 * allowing to have multiple test cases run in same time.
	 * For set amount of available Threads kindly change in pom.xml at threadCount tag
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	/**
	 * Initialise the WebDriver based on selected navigator.
	 * @author Lucas Alexandre Bez Piancoski
	 * @return Instantiated WebDriver
	 * @since 1.0
	 */
	public static WebDriver initDriver() {
		WebDriver driver = null;
		switch (Properties.BROWSER) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case EDGE:
				driver = new EdgeDriver();
				break;
			default:
				driver = new EdgeDriver();
				break;
		}
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * Get the instantiated Thread of the WebDriver.
	 * @author Lucas Alexandre Bez Piancoski
	 * @return the driver
	 * @since 1.0
	 */
	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	/**
	 * Clean and kill the ThreadDriver and WebDriver if is not null.
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}
}
