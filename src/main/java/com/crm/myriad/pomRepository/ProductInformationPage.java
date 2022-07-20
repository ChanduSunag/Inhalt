package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.myriad.genericlibrary.WebDriverLibrary;

public class ProductInformationPage extends WebDriverLibrary{

	WebDriver driver;
	public ProductInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreicon;
	@FindBy(name="Campaigns")
	private WebElement campaignmodule;

	public WebElement getMoreicon() {
		return moreicon;
	}
	public WebElement getCampaignmodule() {
		mouseOverOnElement(driver, campaignmodule);
		return campaignmodule;
	}


}
