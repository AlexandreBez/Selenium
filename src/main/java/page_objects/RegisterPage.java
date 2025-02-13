package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configs.BasePage;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void setUserID(String username_id) {
		dsl.write(By.name("username"), username_id);
	}
	
	public void setPassword(String password) {
		dsl.write(By.name("password"), password);
	}
	
	public void setRepeatPassword(String repeatPassword) {
		dsl.write(By.name("repeatedPassword"), repeatPassword);
	}
	
	public void setFirstName(String firstName) {
		dsl.write(By.name("account.firstName"), firstName);
	}
	
	public void setLastName(String lastName) {
		dsl.write(By.name("account.lastName"), lastName);
	}
	
	public void setEmail(String email) {
		dsl.write(By.name("account.email"), email);
	}
	
	public void setPhome(String phone) {
		dsl.write(By.name("account.phone"), phone);
	}
	
	public void setAddress1(String address1) {
		dsl.write(By.name("account.address1"), address1);
	}
	
	public void setAddress2(String address2) {
		dsl.write(By.name("account.address2"), address2);
	}
	
	public void setCity(String city) {
		dsl.write(By.name("account.city"), city);
	}
	
	public void setState(String state) {
		dsl.write(By.name("account.state"), state);
	}
	
	public void setZip(String zip) {
		dsl.write(By.name("account.zip"), zip);
	}
	
	public void setContry(String country) {
		dsl.write(By.name("account.country"), country);
	}
	
	
	public void setEnglishAsLanguagePreference() {
		dsl.selectOptionFromCombo(By.name("account.languagePreference"), "english");
	}
	
	public void setJaponesAsLanguagePreference() {
		dsl.selectOptionFromCombo(By.name("account.languagePreference"), "japanese");
	}
	
	
	public void setFishAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "FISH");
	}
	
	public void setDogsAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "DOGS");
	}
	
	public void setReptilesAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "REPTILES");
	}
	
	public void setCatsAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "CATS");
	}
	
	public void setBirdsAsFavouriteCategory() {
		dsl.selectOptionFromCombo(By.name("account.favouriteCategoryId"), "BIRDS");
	}
	
	
	public void setEnabledMyList() {
		if (!dsl.isRadioSelected(By.name("account.listOption"))) {		
			dsl.selectRadio(By.name("account.listOption"));
		}
	}
	
	public void setDisabledMyList() {
		if (dsl.isRadioSelected(By.name("account.listOption"))) {		
			dsl.selectRadio(By.name("account.listOption"));
		}		
	}
	
	
	public void setEnableMyBanner() {
		if (!dsl.isRadioSelected(By.name("account.bannerOption"))) {
			dsl.selectRadio(By.name("account.bannerOption"));
		}
	}
	
	public void setDisabledMyBanner() {
		if (dsl.isRadioSelected(By.name("account.bannerOption"))) {		
			dsl.selectRadio(By.name("account.bannerOption"));
		}
	}
	
	
	public void confirmAccountRegistration() {
		dsl.clickButton(By.name("newAccount"));
	}
	
	public void confirmAccountModification() {
		dsl.clickButton(By.name("editAccount"));
	}
	
	
	public String getLastNameValue() {
		return dsl.getText(By.name("account.lastName"));	
	}
}
