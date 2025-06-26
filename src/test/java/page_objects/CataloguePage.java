package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import base.CatalogueItemDetails;

/**
 * Catalogue page object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class CataloguePage extends BasePage{
	
	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public CataloguePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Return to main catalogue page
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void navigateToMainMenu() {
		dsl.clickLink(By.xpath("//a[normalize-space()=\"Return to Main Menu\"]"));
	}
	
	// ============================Lateral Catalogue Menu===============================
	
	/**
	 * Navigate to birds catalogue items using lateral menu
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void navigateToBirdsCatalogItemsFromLateralMenu() {
		dsl.clickLink(By.xpath("(//img[@src='../images/birds_icon.gif'])[1]"));
	}
	
	// ============================Horizontal Catalogue Menu===============================
	
	/**
	 * Navigate to birds catalogue items using horizontal menu
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void navigateToBirdsCatalogItemsFromHorizontalMenu() {
		dsl.clickLink(By.xpath("//img[@src=\"../images/sm_birds.gif\"]"));
	}
	
	/**
	 * Navigate to dogs catalogue items using horizontal menu
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void navigateToDogsCatalogItemsFromHorizontalMenu() {
		dsl.clickLink(By.xpath("//img[@src=\"../images/sm_dogs.gif\"]"));
	}
	
	// ============================Access and Details of Amazon Parrot===============================
	
	/**
	 * Navigate to Amazon Parrot catalogue items
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void accessAmazonParrotCatalogueItems() {
		dsl.clickLink(By.xpath("//a[normalize-space()=\"AV-CB-01\"]"));
	}
	
	/**
	 * Verify if Adult Male Amazon Parrot Details In Catalogue is correct
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean verifyAdultMaleAmazonParrotDetailsInCatalogue() {
		CatalogueItemDetails adultAmazonParrot = CatalogueItemDetails.ADULT_MALE_AMAZON_PARROT;
		return dsl.verifyIfListOfValuesExistOnTableRow(By.xpath("//div[@id=\"Catalog\"]//table"), adultAmazonParrot.getItemsAsList());
	}
	
	/**
	 * Add Adult Male Amazon Parrot to cart
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void addAdultMaleAmazonParrotToCart() {
		dsl.selectElementOnCellWithExpectedValueAtTable(By.xpath("//div[@id=\"Catalog\"]//table"), By.xpath("//a[normalize-space()=\"Add to Cart\"]"), "EST-18");
	}
	
	// ============================Access and Details of Poodle===============================
	
	/**
	 * Navigate to Poodle catalogue items
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void accessPoodleCatalogueItems() {
		dsl.clickLink(By.xpath("//a[normalize-space()=\"K9-PO-02\"]"));
	}
	
	/**
	 * Verify if Poodle Details In Catalogue is correct
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean verifyPoodleDetailsInCatalogue() {
		CatalogueItemDetails malePuppyPoodle = CatalogueItemDetails.MALE_PUPPY_POODLE;
		return dsl.verifyIfListOfValuesExistOnTableRow(By.xpath("//div[@id=\"Catalog\"]//table"), malePuppyPoodle.getItemsAsList());
	}
	
	/**
	 * Add Poodle to cart
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void addPoodleToCart() {
		dsl.selectElementOnCellWithExpectedValueAtTable(By.xpath("//div[@id=\"Catalog\"]//table"), By.xpath("//a[normalize-space()=\"Add to Cart\"]"), "EST-8");
	}
	
}
