package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {


	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath= "//span[@class='dvHeaderText']")
	private WebElement contactVerify;
	
	@FindBy(name= "Delete")
	private WebElement deleteButton;

	public WebElement getContactVerify() {
		return contactVerify;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}


}
