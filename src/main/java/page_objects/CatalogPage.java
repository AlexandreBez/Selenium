package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configs.BasePage;

public class CatalogPage extends BasePage{

	public CatalogPage(WebDriver driver) {
		super(driver);
	}

	public void navigateToSignIn() {
		dsl.clickLink(By.linkText("Sign In"));
	}
	
	public void navigateToMyAccount() {
		dsl.clickLink(By.linkText("My Account"));
	}
}
