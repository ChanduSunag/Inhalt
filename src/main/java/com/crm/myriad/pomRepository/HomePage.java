package com.crm.myriad.pomRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.myriad.genericlibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary{

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgModule;

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactModule;

	@FindBy(xpath="//a[text()='Products']")
	private WebElement productModule;

	@FindBy(linkText = "More")
	private WebElement moreOpt;

	@FindBy(name="Campaigns")
	private WebElement campaignModule;

	@FindBy(xpath="(//a[text()='Purchase Order'])[1]")
	private WebElement purchaseOrder;

	@FindBy(css="a[href='index.php?module=Users&action=Logout']")
	private WebElement logoutButton;

	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;

	public WebElement getOrganizationmodule() {
		return orgModule;
	}

	public WebElement getContactmodule() {
		return contactModule;
	}

	public WebElement getProductmodule() {
		return productModule;
	}

	public WebElement getCampaignmodule() {
		return campaignModule;
	}

	public WebElement getPurchaseorder() {
		return purchaseOrder;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public void logoutInhalt() {
		mouseOverOnElement(driver, logoutImg);
		logoutButton.click();
	}

	public WebElement getMoreOpt() {
		return moreOpt;
	}
}