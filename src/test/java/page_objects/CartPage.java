package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * Cart page object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class CartPage extends BasePage{

	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public Boolean verifyIfItemIsAddedtoCart(List<String> item) {
		return dsl.verifyIfListOfValuesExistOnTableRow(By.xpath("//form[@method=\"post\"]//table"), item);
	}
	
	/**
	 * Click on the Checkout Button and proceed with order
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void proceedToCheckout() {
		dsl.clickOnButton(By.xpath("//a[normalize-space()=\"Proceed to Checkout\"]"));
	}
	
}
