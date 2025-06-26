package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

/**
 * Register page object to maintain respective functionality avoiding extra work if any ID change in future
 * as well helping on code maintenance and re-usability
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/">Selenium guidance for Page Object Models</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class RegisterPage extends BasePage{

	/**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
	 * @param driver Obligated for call the WebDriver instance
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Type the user login on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setUserID(String username_id) {
		dsl.write(By.name("username"), username_id);
	}
	
	/**
	 * Type the user password on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setPassword(String password) {
		dsl.write(By.name("password"), password);
	}
	
	/**
	 * Type the user confirm password on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setRepeatPassword(String repeatPassword) {
		dsl.write(By.name("repeatedPassword"), repeatPassword);
	}
	
	/**
	 * Type the user first name on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setFirstName(String firstName) {
		dsl.write(By.name("account.firstName"), firstName);
	}
	
	/**
	 * Type the user last name on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setLastName(String lastName) {
		dsl.write(By.name("account.lastName"), lastName);
	}
	
	/**
	 * Type the user email on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setEmail(String email) {
		dsl.write(By.name("account.email"), email);
	}
	
	/**
	 * Type the user phone on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setPhone(String phone) {
		dsl.write(By.name("account.phone"), phone);
	}
	
	/**
	 * Type the user address 1 on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setAddress1(String address1) {
		dsl.write(By.name("account.address1"), address1);
	}
	
	/**
	 * Type the user email on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setAddress2(String address2) {
		dsl.write(By.name("account.address2"), address2);
	}
	
	/**
	 * Type the user email on city form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setCity(String city) {
		dsl.write(By.name("account.city"), city);
	}
	
	/**
	 * Type the user email on state form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setState(String state) {
		dsl.write(By.name("account.state"), state);
	}
	
	/**
	 * Type the user zip on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setZip(String zip) {
		dsl.write(By.name("account.zip"), zip);
	}
	
	/**
	 * Type the user country on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setContry(String country) {
		dsl.write(By.name("account.country"), country);
	}
	
	/**
	 * Select English as user language preference on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setEnglishAsLanguagePreference() {
		dsl.selectOptionFromCombo(By.name("account.languagePreference"), "english");
	}
	
	/**
	 * Select Japanese as user language preference on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setJaponesAsLanguagePreference() {
		dsl.selectOptionFromCombo(By.name("account.languagePreference"), "japanese");
	}
	
	/**
	 * Select Fish as user favourite category on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setFishAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "FISH");
	}
	
	/**
	 * Select Dog as user favourite category on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setDogsAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "DOGS");
	}
	
	/**
	 * Select Reptile as user favourite category on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setReptilesAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "REPTILES");
	}
	
	/**
	 * Select Cat as user favourite category on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setCatsAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "CATS");
	}
	
	/**
	 * Select Bird as user favourite category on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setBirdsAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "BIRDS");
	}
	
	/**
	 * Enable My list on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setEnabledMyList() {
		if (!dsl.isRadioSelected(By.name("account.listOption"))) {		
			dsl.selectRadio(By.name("account.listOption"));
		}
	}
	
	/**
	 * Disable My list on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setDisabledMyList() {
		if (dsl.isRadioSelected(By.name("account.listOption"))) {		
			dsl.selectRadio(By.name("account.listOption"));
		}		
	}
	
	/**
	 * Enable My banner on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setEnableMyBanner() {
		if (!dsl.isRadioSelected(By.name("account.bannerOption"))) {
			dsl.selectRadio(By.name("account.bannerOption"));
		}
	}
	
	/**
	 * Disable My banner on registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void setDisabledMyBanner() {
		if (dsl.isRadioSelected(By.name("account.bannerOption"))) {		
			dsl.selectRadio(By.name("account.bannerOption"));
		}
	}
	
	/**
	 * Click on Save Account button at registration form
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void confirmAccountRegistration() {
		dsl.clickOnButton(By.name("newAccount"));
	}

}
