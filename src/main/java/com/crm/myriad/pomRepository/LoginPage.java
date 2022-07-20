package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.myriad.genericlibrary.WebDriverLibrary;


public class LoginPage extends WebDriverLibrary{

	WebDriver driver;
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy (name="user_name")
	private WebElement usnTB;

	@FindBy(name="user_password")
	private WebElement pwdTB;

	@FindBy(id="submitButton")
	private WebElement loginButton;


	public WebElement getUsnTB() {
		return usnTB;
	}

	public WebElement getPwdTB() {
		return pwdTB;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * it's used to login into the Inhalt
	 * @author Chandan
	 */
	
	public void loginToInhalt(String url,String username,String password) {
		driver.get(url);
		waitForElementInDOM(driver);
		usnTB.sendKeys(username);
		pwdTB.sendKeys(password);
		loginButton.click();
	}


}
