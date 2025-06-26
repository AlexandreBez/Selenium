package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * Login page object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class LoginPage extends BasePage{

	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Type the user login on login form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setUser(String username) {
		dsl.write(By.name("username"), username);
	}
	
	/**
	 * Type the user password on login form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setPass(String password) {
		dsl.write(By.name("password"), password);
	}
	
	/**
	 * Click on the login button
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void clickLogin() {
		dsl.clickOnButton(By.name("signon"));
	}
	
	/**
	 * Re-direct user to register now page
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void accessTheRegisterNow() {
		dsl.clickLink(By.linkText("Register Now!"));
	}
	
	/**
	 * Verify if sign on button is visible at login form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean verifyLoginButtonIsVisible() {
		if (dsl.verifyIfElementExist(By.name("signon"))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verify if Register Now link is visible at login page
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean verifyRegisterNowLinkIsVisible() {
		if (dsl.verifyIfElementExist(By.xpath("//a[normalize-space()=\"Register Now!\"]"))) {
			return true;
		}
		return false;
	}
}
