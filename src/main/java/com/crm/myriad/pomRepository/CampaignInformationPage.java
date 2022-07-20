package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {

	WebDriver driver;
	public CampaignInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath= "//span[@class='dvHeaderText']")
	private WebElement verifyCmp;

	public WebElement getVerifyCmp() {
		return verifyCmp;
	}


}
