package test_cases;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;

import configs.BaseTest;
import configs.DriverFactory;
import page_objects.CatalogPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

@RunWith(Parameterized.class)
public class hands_on extends BaseTest{
	
	@Parameter(value=0)
	public String userID;
	@Parameter(value=1)
	public String password;
	@Parameter(value=2)
	public String firstName;
	@Parameter(value=3)
	public String lastName;
	@Parameter(value=4)
	public String email;
	@Parameter(value=5)
	public String phone;
	@Parameter(value=6)
	public String address1;
	@Parameter(value=7)
	public String address2;
	@Parameter(value=8)
	public String city;
	@Parameter(value=9)
	public String state;
	@Parameter(value=10)
	public String zip;
	@Parameter(value=11)
	public String country;
	
	private RegisterPage registerPage;
	private CatalogPage catalogPage;
	private LoginPage loginPage;
	
	public WebDriverWait wait;

	@Before
	public void InitializeDriver() {
		DriverFactory.getDriver().get("https://petstore.octoperf.com/actions/Catalog.action");
		registerPage = new RegisterPage(DriverFactory.getDriver());
		catalogPage = new CatalogPage(DriverFactory.getDriver());
		loginPage = new LoginPage(DriverFactory.getDriver());
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"LucasTest", "test@123", "Lucas", "Test", "test@test.com", "123123456", "Street Jhon Doe", "1", "Nowhere", "Somewhere", "000789", "NA"}
		});
	}
	
	@Test
	public void RegisterNewUserAndLoginWithSuccess() {
		
		catalogPage.navigateToSignIn();
		loginPage.navigateToRegisterNow();
		
		registerPage.setUserID(userID);
		registerPage.setPassword(password);
		registerPage.setRepeatPassword(password);
		registerPage.setFirstName(firstName);
		registerPage.setLastName(lastName);
		registerPage.setEmail(email);
		registerPage.setPhome(phone);
		registerPage.setAddress1(address1);
		registerPage.setAddress2(address2);
		registerPage.setCity(city);
		registerPage.setState(state);
		registerPage.setZip(zip);
		registerPage.setContry(country);
		registerPage.setEnglishAsLanguagePreference();
		registerPage.setCatsAsFavouriteCategory();
		registerPage.setEnabledMyList();
		registerPage.setEnableMyBanner();
		registerPage.confirmAccountRegistration();
		
		catalogPage.navigateToSignIn();
		
		loginPage.setUser(userID);
		loginPage.setPass(password);
		loginPage.clickLogin();
	}
	
	@Test
	public void ChangeAccountLastNameWithSuccess() {
		
		
		catalogPage.navigateToSignIn();
		
		loginPage.setUser(userID);
		loginPage.setPass(password);
		loginPage.clickLogin();
		
		catalogPage.navigateToMyAccount();
		
		registerPage.setLastName("Account");
		registerPage.confirmAccountModification();
		Assert.assertNotEquals(lastName, registerPage.getLastNameValue());
	}
	
	@Test
	public void PlaceOrderWithDifferentShippingAddressWithSuccess() {
		
	}
	
	@Test
	public void Logged_User_Navigate_At_Shop_And_Cart_Page_Not_Placing_Order_And_Login_Out_With_Success() {
		
	}
	
}
