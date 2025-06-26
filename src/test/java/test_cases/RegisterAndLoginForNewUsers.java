package test_cases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import base.data.UserData;
import configs.DriverFactory;

/**
 * Assignment 1
 * Collection of Registration and Login of users test cases
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class RegisterAndLoginForNewUsers extends BaseTest{
	
	/**
	 * Get the new user Login data for test cases
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	final UserData newUserData = listOfUserData.get(0);
	
	/**
	 * Before each test execution the actions inside of the class will be executed first allowing re-usibility and less code 
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	@BeforeEach
	private void testCasePrep() {
		DriverFactory.getDriver().get("https://petstore.octoperf.com/actions/Catalog.action");
		initializePageObjects();
	}
	
	/**
	 * Register a new user and login with success
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	@Test
	@Tag("high")
	public void registerAndLoginNewUserWithSuccess() {
		
		/**
		 * Navigate with success to 'Sign in' page and the same should be displayed with 'Login' and 'Register Now' button
		 */
		navigationArea.navigateToSignIn();
		Assertions.assertTrue(loginPage.verifyLoginButtonIsVisible());
		Assertions.assertTrue(loginPage.verifyRegisterNowLinkIsVisible());
		
		/**
		 * User must be able to see the 'registration' page
		 */
		loginPage.accessTheRegisterNow();
		
		/**
		 * User must be able to register a new user successfully
		 */
		registerPage.setUserID(newUserData.userID);
		registerPage.setPassword(newUserData.password);
		registerPage.setRepeatPassword(newUserData.password);
		registerPage.setFirstName(newUserData.firstName);
		registerPage.setLastName(newUserData.lastName);
		registerPage.setEmail(newUserData.email);
		registerPage.setPhone(newUserData.phone);
		registerPage.setAddress1(newUserData.address1);
		registerPage.setAddress2(newUserData.address2);
		registerPage.setCity(newUserData.city);
		registerPage.setState(newUserData.state);
		registerPage.setZip(newUserData.zip);
		registerPage.setContry(newUserData.country);
		registerPage.setEnglishAsLanguagePreference();
		registerPage.setCatsAsFavouriteCategory();
		registerPage.setEnabledMyList();
		registerPage.setEnableMyBanner();
		registerPage.confirmAccountRegistration();
		
		/**
		 * User must be able to login successfully
		 */
		navigationArea.navigateToSignIn();
		loginPage.setUser(newUserData.userID);
		loginPage.setPass(newUserData.password);
		loginPage.clickLogin();
		
	}
	
}
