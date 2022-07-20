package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	WebDriver driver;
	public CreatingNewCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignname")
	private WebElement campNameField;

	@FindBy(name= "button")
	private WebElement saveButton;

	@FindBy(css = "img[src='themes/softed/images/select.gif']")
	private WebElement addProcduct;

	public WebElement getCampNameField() {
		return campNameField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getAddProcduct() {
		return addProcduct;
	}



}
