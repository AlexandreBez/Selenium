package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.data.UserData;
import configs.DriverFactory;
import configs.Properties;

import page_objects.CartPage;
import page_objects.CataloguePage;
import page_objects.LoginPage;
import page_objects.NavigationArea;
import page_objects.OrderPage;
import page_objects.RegisterPage;
import page_objects.UserAccountDetailsPage;

/**
 * Class to implement and reuse the DSL and other implementations by heritage on TestCases classes avoiding 
 * unnecessary code writing
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class BaseTest {

	//============================PAGE OBJECT IMPORT=======================================
	
	/** 
	 * Import of the Cart Page Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public CartPage cartPage;
	
	/** 
	 * Import of the Catalogue Page Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public CataloguePage cataloguePage;
	
	/** 
	 * Import of the Login Page Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public LoginPage loginPage;
	
	/** 
	 * Import of the Navigation Area Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public NavigationArea navigationArea;
	
	/** 
	 * Import of the Order Page Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public OrderPage orderPage;
	
	/** 
	 * Import of the Register Page Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public RegisterPage registerPage;
	
	/** 
	 * Import of the User Account Details Page Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public UserAccountDetailsPage accountDetailsPage;
	
	protected void initializePageObjects() {
	    WebDriver driver = DriverFactory.getDriver();
	    this.cartPage = new CartPage(driver);
	    this.cataloguePage = new CataloguePage(driver);
	    this.loginPage = new LoginPage(driver);
	    this.navigationArea = new NavigationArea(driver);
	    this.orderPage = new OrderPage(driver);
	    this.registerPage = new RegisterPage(driver);
	    this.accountDetailsPage = new UserAccountDetailsPage(driver);
	}

	
	
	//============================DATA MAINTANANCE=======================================

	/**
	 * Test data for test case purpose allowing to be share among the test cases classes
	 * and for easy maintenance of Test data for test case execution
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public static List<UserData> listOfUserData = Arrays.asList(
			new UserData("LucasTest3", "test@123", "Lucas", "Test", "test@test.com", "123123456", "Street A", "1", "City B", "State C", "123456789", "Somewhere"),
			new UserData("LucasTest3", "test@123", "Lucas", "Admin", "test@test.com", "123123456", "Street C", "25", "City B", "State A", "123456000", "Somewhere")
	);
	
	
	//============================@AFTEREACH=======================================

	/**
	 * When finishing the test run either with success or error save a screenshot on 'screenshots' folder
	 * with run date and test case name, as well call the {@link configs.DriverFactory#killDriver()} 
	 * to stop and clear the driver after test execution
	 * @throws IOException
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	@AfterEach
	public void QuitDriver(TestInfo testInfo) throws IOException {

		if (Properties.TAKE_SCREENSHOT) {			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss"); 
			String timestamp = sdf.format(new Date());
			
			TakesScreenshot test_case_screenshot = (TakesScreenshot) DriverFactory.getDriver();
			File screenshot_file = test_case_screenshot.getScreenshotAs(OutputType.FILE);
			
			String filename = "screenshots"+ File.separator + testInfo.getDisplayName() + File.separator + timestamp + ".jpg";
			FileUtils.copyFile(screenshot_file, new File(filename));
		}

	    DriverFactory.killDriver();
	}
}
