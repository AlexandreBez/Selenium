package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * Navigation area object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class NavigationArea extends BasePage{

	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public NavigationArea(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Navigate to login page
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void navigateToSignIn() {
		dsl.clickLink(By.linkText("Sign In"));
	}
	
	/**
	 * Navigate to account details page
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void navigateToMyAccount() {
		dsl.clickLink(By.linkText("My Account"));
	}
	
	/**
	 * log out from account
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void signOutFromAccount() {
		dsl.clickLink(By.xpath("//a[normalize-space()=\"Sign Out\"]"));
	}

}
