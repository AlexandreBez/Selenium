package test_cases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import base.data.UserData;
import configs.DriverFactory;

/**
 * Assignment 2
 * Collection of modification on User Account details test cases
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class UserAccountModifications extends BaseTest{


	/**
	 * Get the new user Login data for test cases
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	final UserData userModificationData = listOfUserData.get(1);
	
	/**
	 * Before each test execution the actions inside of the class will be executed first allowing re-usibility and less code 
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	@BeforeEach
	public void testCasePrep() {
		DriverFactory.getDriver().get("https://petstore.octoperf.com/actions/Catalog.action");
		initializePageObjects();
		navigationArea.navigateToSignIn();
		loginPage.setUser(userModificationData.userID);
		loginPage.setPass(userModificationData.password);
		loginPage.clickLogin();
	}
	
	/**
	 * Modify Last Name of a user, save with success the changes and logout from account
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	@Test
	@Tag("medium")
	public void ChangeAccountLastNameWithSuccess() {
		
		/**
		 * Save last name for test purpose
		 */
		String originalLastName;
		
		/**
		 * 'My Account' page should be displayed with user account details		
		 */
		navigationArea.navigateToMyAccount();
		originalLastName = accountDetailsPage.getLastNameValueFromAccountDetailsForm();
		
		/**
		 * User must be able to change 'Last Name' successfully
		 */
		accountDetailsPage.modifyLastName(userModificationData.lastName);
		accountDetailsPage.confirmAccountModification();
		cataloguePage.navigateToBirdsCatalogItemsFromHorizontalMenu();
		navigationArea.navigateToMyAccount();
		Assertions.assertNotEquals(originalLastName, accountDetailsPage.getLastNameValueFromAccountDetailsForm());
		
		/**
		 * User should be able to logout
		 */
		navigationArea.signOutFromAccount();
	}
}
