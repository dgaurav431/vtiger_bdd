package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	public void waitForElementsToLoaded(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
	}

	public void maximizeTheWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement elementToClick) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
	}

	public void selectFromADropdown(WebElement dropdown, String option) {

		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	public void selectFromADropdown(WebElement dropdown, int index) {

		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	public void javaScriptClick(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(IPathConstant.JAVASCRIPT_COMMAND_FOR_CLICK, element);
	}

	public void javaScriptEnterValues(WebDriver driver, WebElement element, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=" + value + "", element);
	}

	public static void takeAScreenShot(WebDriver driver, String filePath) throws WebDriverException, IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		Files.copy(ts.getScreenshotAs(OutputType.FILE),
				new File(filePath));

	}

	public void mouseHoverOnAElement(WebDriver driver, WebElement element) {

		new Actions(driver).moveToElement(element).perform();
	}

	public void selectOKInAlertPopUp(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	public void selecCancelInAlertPopUp(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}
	
	public void switchToChildBorwser(WebDriver driver, String partialWindowTitle) {
		
		Set<String> allIDS = driver.getWindowHandles();
		
		for(String id:allIDS) {
			
			driver.switchTo().window(id);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
			
		}
		
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		
		driver.switchTo().frame(frameElement);
	}

}
