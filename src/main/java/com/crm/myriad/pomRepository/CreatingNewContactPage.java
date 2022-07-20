package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.myriad.genericlibrary.ExcelLibrary;
import com.crm.myriad.genericlibrary.JavaLibrary;

public class CreatingNewContactPage {
	

	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastnameTB;

	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(xpath= "(//img[ @src='themes/softed/images/select.gif'])[1]")
	private WebElement newOrgImg;

	public WebElement getLastnameTB() {
		return lastnameTB;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void CreateContactWithMandatory() throws Throwable {
		JavaLibrary jLib=new JavaLibrary();
		ExcelLibrary eLib=new ExcelLibrary();
		int randomNum = jLib.getRandomNumber();
		String lastname = eLib.getStringDataFromExcel("ContactData", 1, 0);
		lastnameTB.sendKeys(lastname+randomNum);
		saveButton.click();
	}

	public void CreateContactWithProduct() throws Throwable {
		ExcelLibrary eLib=new ExcelLibrary();
		String lastname = eLib.getStringDataFromExcel("ContactData", 1, 0);
		lastnameTB.sendKeys(lastname);
		newOrgImg.click();
	}

	public WebElement getNewOrgImg() {
		return newOrgImg;
	}

}
