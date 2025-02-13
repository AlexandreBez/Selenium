package configs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
		
	public void write(By by, String text){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}
	
	public String getElementValue(By by, String id_el) {
		return driver.findElement(by).getDomProperty("value");
	}
	
	
	public void selectRadio(By by) {
		driver.findElement(by).click();
	}
	
	public boolean isRadioSelected(By by){
		return driver.findElement(by).isSelected();
	}
	
	
	public void selectCheckbox(By by) {
		driver.findElement(by).click();
	}
	
	public boolean isCheckboxSelected(By by){
		return driver.findElement(by).isSelected();
	}
	
	
	public void selectOptionFromCombo(By by, String text) {
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
	}
	
	public List<String> returnOptionsFromCombo(By by) {
		
		Select combo = new Select(driver.findElement(by));
		List<String> options = new ArrayList<String>();
		for(WebElement option: combo.getOptions()) {
			options.add(option.getText());
		}
		return options;
	}
	
	
	public void clickButton(By by) {
		driver.findElement(by).click();
	}
	
	
	public void clickLink(By by) {
		driver.findElement(by).click();
	}
	
	
	public String getText(By by) {
		return driver.findElement(by).getText();
	}
	
	
}
