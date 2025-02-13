package configs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();

	@After
	public void QuitDriver() throws IOException {

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss"); 
	    String timestamp = sdf.format(new Date());

	    TakesScreenshot test_case_screenshot = (TakesScreenshot) DriverFactory.getDriver();
	    File screenshot_file = test_case_screenshot.getScreenshotAs(OutputType.FILE);

	    String filename = "screenshoots"+ File.separator + testName.getMethodName() + "_" + timestamp + ".jpg";
	    FileUtils.copyFile(screenshot_file, new File(filename));

	    DriverFactory.killDriver();
	}
}
