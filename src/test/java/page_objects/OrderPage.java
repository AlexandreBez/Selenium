package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * Order page object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class OrderPage extends BasePage{
	
	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public OrderPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectDifferentShippingAddress() {
		dsl.selectCheckbox(By.xpath("//input[@name='shippingAddressRequired']"));
	}
	
	public void proceedToOrderConfirmation() {
		dsl.clickOnButton(By.xpath("//input[@name=\"newOrder\"]"));
	}
	
	public void changeShippingAddress1(String address1) {
		dsl.write(By.xpath("//input[@name='order.billAddress1']"), address1);
	}
	
	public void changeShippingAddress2(String address2) {
		dsl.write(By.xpath("//input[@name='order.shipAddress2']"), address2);
	}
	
	public void changeShippingCity(String city) {
		dsl.write(By.xpath("//input[@name='order.shipCity']"), city);
	}
	
	public void changeShippingState(String state) {
		dsl.write(By.xpath("//input[@name='order.shipState'])"), state);
	}
	
	public void changeShippingZip(String zip) {
		dsl.write(By.xpath("//input[@name='order.shipZip']"), zip);
	}
	
	public void changeShippingCountry(String country) {
		dsl.write(By.xpath("//input[@name='order.shipCountry']"), country);
	}
	
	public Boolean checkValueIsCorrectOnOrderVerification(String value) {
		return dsl.verifyIfValueExistOnTable(By.xpath("//tbody"), value);
	}
	
	public void confirmOrder() {
		dsl.clickOnButton(By.xpath("//a[normalize-space()=\"Confirm\"]"));
	}
	
	public String getMessageFromConfirmOrderCreation() {
		return dsl.getText(By.xpath("//li[normalize-space()=\"Thank you, your order has been submitted.\"]"));
	}
	
	public Boolean checkValueIsCorrectOnOrderInformationsConfirmation(String value) {
		return dsl.verifyIfValueExistOnTable(By.xpath("(//tbody)[1]"), value);
	}
	
	public Boolean checkValueIsCorrectOnOrderItemsConfirmation(String value) {
		return dsl.verifyIfValueExistOnTable(By.xpath("(//tbody)[2]"), value);
	}
	
}
