package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configs.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setUser(String username) {
		dsl.write(By.name("username"), username);
	}
	
	public void setPass(String password) {
		dsl.write(By.name("password"), password);
	}
	
	public void clickLogin() {
		dsl.clickButton(By.name("signon"));
	}
	
	public void navigateToRegisterNow() {
		dsl.clickLink(By.linkText("Register Now!"));
	}
}
