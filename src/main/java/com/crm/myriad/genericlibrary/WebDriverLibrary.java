package com.crm.myriad.genericlibrary;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  * it contains all the WebDriver specific reusable methods
 * @author chandan
 */

public class WebDriverLibrary implements IConstantLibrary{

	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
	}

	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}

	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForElement (WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	} 

	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the value from the dropDwon  based on visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option available in GUI
	 * @param element
	 * @param value
	 */
	
	public void selectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click  on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
