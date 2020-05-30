package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {
	/**
	 * first clears the Element ending and Sends Keys you type as Argument
	 * 
	 * @param element
	 * @param text
	 */

	public static void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	/**
	 * Parameters are (List<WebElement> radioOrCheckbox, String value)
	 * 
	 * @param radioOrCheckbox
	 * @param value
	 */

	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();

			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	/**
	 * Selecting options by given Text
	 * 
	 * @param element
	 * @param text
	 */

	public static void selectDdValue(WebElement element, String text) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();//collection
			for (WebElement el : options) {
				if (el.getText().equals(text)) {
					select.selectByVisibleText(text);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Selecting options by giving Index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();//2
			if (size > index) {
				select.selectByIndex(index);
				

			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method just accepts Alert alert = driver.switchTo().alert();
	 * alert.accept();
	 */

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The method just dismiss/cancels Alert alert = driver.switchTo().alert();
	 * alert.dismiss();
	 */

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The method just retrieves Text of Alert Alert alert =
	 * driver.switchTo().alert(); String alertText=alert.getText();
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * Methods that sends text to alert and catches exception if alert is not
	 * present
	 * 
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switching to Frame enter a NAME of Frame
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switching to Frame enter a WebElement of Frame
	 * 
	 * @param nameOrId
	 */

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switching to Frame enter a int/index of Frame
	 * 
	 * @param nameOrId
	 */

	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	public static WebElement cssSelector(String cssSelector) {

		return driver.findElement(By.cssSelector(cssSelector));
	}

	public static WebElement xpath(String xpath) {

		return driver.findElement(By.xpath(xpath));
	}

	public static void switchSecondWindow(int index) {

		Set<String> windows = driver.getWindowHandles();
		List<String> window = new ArrayList<>(windows);
		if (index == 0) {
			String mainWindow = window.get(0);
			driver.switchTo().window(mainWindow);
		}
		if (index == 1) {
			String secondWindow = window.get(1);
			driver.switchTo().window(secondWindow);
		}
		if (index == 2) {
			String secondWindow = window.get(2);
			driver.switchTo().window(secondWindow);
		}
	}
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	
	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}
	/**
	 * This Method will take a screenshot
	 * 
	 * @param filename
	 */
	public static void takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshot/" + filename + ".png"));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
	}

}
