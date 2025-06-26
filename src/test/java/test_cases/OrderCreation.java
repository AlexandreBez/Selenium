package test_cases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import base.CatalogueItemDetails;
import base.data.UserData;
import configs.DriverFactory;

/**
 * Assignment 3 and 4
 * Collection of Order creation and Login of users test cases
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class OrderCreation extends BaseTest{
	
	/**
	 * Get the new user Login data for test cases
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	final UserData orderUser = listOfUserData.get(1);
	
	/**
	 * Before each test execution the actions inside of the class will be executed first allowing re-usibility and less code 
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	@BeforeEach
	public void testCasePrep() {
		DriverFactory.getDriver().get("https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	/**
	 * 
	 */
	@Test
	public void PlaceOrderWithDifferentShippingAddressWithSuccess() {
		
		CatalogueItemDetails parrot = CatalogueItemDetails.ADULT_MALE_AMAZON_PARROT;
		CatalogueItemDetails poodle = CatalogueItemDetails.MALE_PUPPY_POODLE;
		
		/**
		 * Login user with success
		 */
		navigationArea.navigateToSignIn();
		loginPage.setUser(orderUser.userID);
		loginPage.setPass(orderUser.password);
		loginPage.clickLogin();
		
		/**
		 * User must be able to add items in cart successfully
		 */
		cataloguePage.navigateToBirdsCatalogItemsFromLateralMenu();
		cataloguePage.accessAmazonParrotCatalogueItems();
		Assertions.assertTrue(cataloguePage.verifyAdultMaleAmazonParrotDetailsInCatalogue());
		cataloguePage.addAdultMaleAmazonParrotToCart();
		Assertions.assertTrue(cartPage.verifyIfItemIsAddedtoCart(parrot.getItemsAsList()));
		
		cataloguePage.navigateToDogsCatalogItemsFromHorizontalMenu();
		cataloguePage.accessPoodleCatalogueItems();
		Assertions.assertTrue(cataloguePage.verifyPoodleDetailsInCatalogue());
		cataloguePage.addPoodleToCart();
		Assertions.assertTrue(cartPage.verifyIfItemIsAddedtoCart(poodle.getItemsAsList()));
		
		cartPage.proceedToCheckout();
		
		/**
		 * User must be able to change shipping address in order page successfully
		 */
		orderPage.changeShippingAddress1(orderUser.address1);
		orderPage.changeShippingAddress2(orderUser.address2);
		orderPage.changeShippingCity(orderUser.city);
		orderPage.changeShippingCountry(orderUser.country);
		orderPage.changeShippingState(orderUser.state);
		orderPage.changeShippingZip(orderUser.zip);
		orderPage.proceedToOrderConfirmation();
		
		/**
		 * User place the order with success
		 */
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderVerification(orderUser.address1));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderVerification(orderUser.address2));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderVerification(orderUser.city));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderVerification(orderUser.country));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderVerification(orderUser.state));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderVerification(orderUser.zip));
		orderPage.confirmOrder();
		
		/**
		 * Confirm order confirmation message
		 */
		Assertions.assertEquals(orderPage.getMessageFromConfirmOrderCreation(), "Thank you, your order has been submitted.");
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderInformationsConfirmation(orderUser.address1));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderInformationsConfirmation(orderUser.address2));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderInformationsConfirmation(orderUser.city));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderInformationsConfirmation(orderUser.country));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderInformationsConfirmation(orderUser.state));
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderInformationsConfirmation(orderUser.zip));
		
		Assertions.assertTrue(orderPage.checkValueIsCorrectOnOrderItemsConfirmation("Total: $16.50"));
		
	}
	
	/**
	 * 
	 */
	@Test
	public void Logged_User_Navigate_At_Shop_And_Cart_Page_Not_Placing_Order_And_Login_Out_With_Success() {
		
	}
	
}
