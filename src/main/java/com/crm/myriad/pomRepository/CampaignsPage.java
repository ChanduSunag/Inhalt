package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	WebDriver driver;
	public CampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css= "img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement createButton;
	
	
	public WebElement getCreateButton() {
		return createButton;
	}


}
