package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgname;
	@FindBy(name="button")
	private WebElement save;

	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getSave() {
		return save;
	}


}
