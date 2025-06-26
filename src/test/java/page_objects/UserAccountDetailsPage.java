package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * User account details page object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class UserAccountDetailsPage extends BasePage{
	
	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public UserAccountDetailsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Update last name on user information form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void modifyLastName(String lastName) {
		dsl.write(By.name("account.lastName"), lastName);
	}
	
	/**
	 * Get last name value on user information form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public String getLastNameValueFromAccountDetailsForm() {
		return dsl.getText(By.name("account.lastName"));
	}
	
	/**
	 * Click on Save Changes button at user information form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void confirmAccountModification() {
		dsl.clickOnButton(By.name("editAccount"));
	}
}
