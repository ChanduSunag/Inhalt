package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.myriad.genericlibrary.ExcelLibrary;
import com.crm.myriad.genericlibrary.WebDriverLibrary;

public class ContactsPage extends WebDriverLibrary{


	WebDriver driver;
	public ContactsPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement createButton;

	@FindBy(name="search_text")
	private WebElement searchField;

	@FindBy(id="bas_searchfield")
	private WebElement dropDown;

	@FindBy(name="submit")
	private WebElement searchButton;

	@FindBy(xpath= "//span[@class='genHeaderSmall']")
	private WebElement noContact;

	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getDropDown() {

		return dropDown;
	}

	public WebElement getSubmitButton() {
		return searchButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getNoContact() {
		return noContact;
	}

	public void checkDeletedContact() throws Throwable {
		ExcelLibrary eLib=new ExcelLibrary();
		String lastname = eLib.getStringDataFromExcel("ContactData", 1, 1);
		searchField.sendKeys(lastname);
		searchButton.click();

	}
}
