package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import configs.Properties;

/**
 * Class to implement and reuse the DSL and other implementations by heritage on PageObject classes avoiding 
 * unnecessary code writing
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class BasePage {

	/**
	 * Import the DSL class
	 * @since 1.0
	 */
	protected DSL dsl;
	
	/**
	 * Import the WebDriverWait class
	 * @since 1.0
	 */
	protected WebDriverWait await;
	
	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * as well the await
	 * @param driver Obligate when BasePage class is call, the WebDriver instance is passed to DSL
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public BasePage(WebDriver driver) {
		dsl = new DSL(driver);
		await = new WebDriverWait(driver, Duration.ofSeconds(Properties.AWAIT_TIME));
	}
	
}
