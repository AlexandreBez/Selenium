package configs;

import org.openqa.selenium.WebDriver;

public class BasePage {

	protected DSL dsl;
	
	public BasePage(WebDriver driver) {
		dsl = new DSL(driver);
	}
}
