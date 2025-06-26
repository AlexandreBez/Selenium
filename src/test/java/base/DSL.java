package base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * A domain specific language (DSL) is a system which provides the user with an expressive means of solving a problem.
 * Allow us to re-use the same code for multiple page objects allowing to work as a library of functions
 * @see <a href="https://www.selenium.dev/documentation/test_practices/encouraged/domain_specific_language/">Selenium Guidance for DSL</a>
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class DSL {

	
    /** 
     * Variable for WebDriver 
     * @author Lucas Alexandre Bez Piancoski
     * @since 1.0
     */
    private WebDriver driver;

    /**
	 * Instantiated a constructor of the class with the WebDriver/ThreadDriver
     * @param driver Obligate when DSL class is call, the WebDriver instance is passed 
     * @author Lucas Alexandre Bez Piancoski
     * @since 1.0
     */
    public DSL(WebDriver driver) {
        this.driver = driver;
    }

	/**
	 * Write a text on a element.
	 * @param by {@link org.openqa.selenium.By}
	 * @param text text to be write
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void write(By by, String text) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}

	/**
	 * Gets the element value from a element
	 * @param by {@link org.openqa.selenium.By}
	 * @return the element value
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public String getElementValue(By by) {
		return driver.findElement(by).getDomProperty("value");
	}

	/**
	 * Select a option on a radio element
	 * @param by {@link org.openqa.selenium.By}
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void selectRadio(By by) {
		driver.findElement(by).click();
	}

	/**
	 * Verify if radio element is selected
	 * @param by {@link org.openqa.selenium.By}
	 * @return true, if radio input is selected
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean isRadioSelected(By by) {
		return driver.findElement(by).isSelected();
	}

	/**
	 * Select a option on a checkbox element
	 * @param by {@link org.openqa.selenium.By}
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void selectCheckbox(By by) {
		driver.findElement(by).click();
	}

	/**
	 * Verify if radio element is selected
	 * @param by {@link org.openqa.selenium.By}
	 * @return true, if is checkbox selected
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean isCheckboxSelected(By by) {
		return driver.findElement(by).isSelected();
	}

	/**
	 * Select a option from a combobox element by the visible text on DOM
	 * @param by {@link org.openqa.selenium.By}
	 * @param text the text of the desired value to select
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void selectOptionFromCombo(By by, String text) {
		WebElement element = driver.findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(text);
	}

	/**
	 * Return the options from combobox element
	 * @param by {@link org.openqa.selenium.By}
	 * @return the list of values from the combobox in a List of string
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public List<String> returnOptionsFromCombo(By by) {

		Select combo = new Select(driver.findElement(by));
		List<String> options = new ArrayList<String>();
		
		for (WebElement option : combo.getOptions()) {
			options.add(option.getText());
		}
		return options;
	}

	/**
	 * Click in a button element
	 * @param by {@link org.openqa.selenium.By}
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void clickOnButton(By by) {
		driver.findElement(by).click();
	}

	/**
	 * Click on a link element
	 * @param by {@link org.openqa.selenium.By}
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void clickLink(By by) {
		driver.findElement(by).click();
	}

	/**
	 * Gets the text from a element
	 * @param by {@link org.openqa.selenium.By}
	 * @return the text from the element in a String format
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public String getText(By by) {
		return driver.findElement(by).getText();
	}

	/**
	 * Verify if a element exist in the DOM
	 * @param by {@link org.openqa.selenium.By}
	 * @return true if is found else false
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public Boolean verifyIfElementExist(By by) {
		if (driver.findElement(by).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Verify if a value exist on a table element by getting the table in a variable
	 * separating the rows from the table to run a for on rows/cells, then if value is found we can 
	 * click on the element(Button, link, etc) under the same row
	 * @param by {@link org.openqa.selenium.By}
	 * @param by_element {@link org.openqa.selenium.By}
	 * @param value the expected value on table
	 * @return true, if successful else false
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public void selectElementOnCellWithExpectedValueAtTable(By by, By by_element, String value) {
		
		WebElement table = driver.findElement(by);
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			
			List<WebElement> columns = row.findElements(By.tagName("td"));
			
			for (WebElement cell : columns) {
				if (cell.getText().trim().contains(value)) {
					WebElement element = row.findElement(by_element);
					element.click();
					return;
				}
			}

		}
	}
	
	/**
	 * Verify if all values from a list exist on a table row element by getting the table in a variable
	 * separating the rows from the table to run a for on rows/cells
	 * @param by {@link org.openqa.selenium.By}
	 * @param value the list with the expected values
	 * @return true, if successful else false
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean verifyIfListOfValuesExistOnTableRow(By by, List<String> values) {
	    
	    WebElement table = driver.findElement(by);
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    for (WebElement row : rows) {
	        String rowText = row.getText().trim();

	        boolean allValuesFound = values.stream().allMatch(rowText::contains);

	        if (allValuesFound) {
	            return true;
	        }
	    }

	    return false;
	}
	
	/**
	 * Verify if a value exist on a table row element by getting the table in a variable
	 * separating the rows from the table to run a for on rows/cells
	 * @param by {@link org.openqa.selenium.By}
	 * @param value the list with the expected values
	 * @return true, if successful else false
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
	 */
	public boolean verifyIfValueExistOnTable(By by, String value) {
	    
	    WebElement table = driver.findElement(by);
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			
			List<WebElement> columns = row.findElements(By.tagName("td"));
			
			for (WebElement cell : columns) {
				if (cell.getText().trim().contains(value)) {
					return true;
				}
			}

		}

	    return false;
	}

}
