package com.crm.myriad.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.myriad.genericlibrary.BaseClass;
import com.crm.myriad.genericlibrary.ExcelLibrary;
import com.crm.myriad.pomRepository.ContactInformationPage;
import com.crm.myriad.pomRepository.ContactsPage;
import com.crm.myriad.pomRepository.CreatingNewContactPage;
import com.crm.myriad.pomRepository.HomePage;

public class ContactTest extends BaseClass{


	@Test(groups = "Smoke Test")
	public void CreateContactTest() throws Throwable {
		HomePage hP=new HomePage(driver);
		ContactsPage cP=new ContactsPage(driver);
		CreatingNewContactPage cncP=new CreatingNewContactPage(driver);
		ContactInformationPage cip=new ContactInformationPage(driver);
		ExcelLibrary eLib=new ExcelLibrary();
		String lastname = eLib.getStringDataFromExcel("ContactData", 1, 0);
		hP.getContactmodule().click();
		cP.getCreateButton().click();
		cncP.getLastnameTB().sendKeys(lastname);
		cncP.getSaveButton().click();

		String actualData = cip.getContactVerify().getText();
		Assert.assertTrue(actualData.contains(lastname));
	}


	@Test(groups = "Regression Test")
	public void CreateAndDeleteContactTest ( ) throws Throwable {
		ExcelLibrary eLib=new ExcelLibrary();
		HomePage hP=new HomePage(driver);  
		ContactsPage cP=new ContactsPage(driver);
		CreatingNewContactPage cncP=new CreatingNewContactPage(driver);
		ContactInformationPage ciP=new ContactInformationPage(driver);
		String lastname = eLib.getStringDataFromExcel("ContactData", 1, 1);
		hP.getContactmodule().click();
		cP.getCreateButton().click();
		cncP.getLastnameTB().sendKeys(lastname);
		cncP.getSaveButton().click();
		ciP.getDeleteButton().click();
		driver.switchTo().alert().accept();
		cP.checkDeletedContact();
		String expectedValue = cP.getNoContact().getText();
		Assert.assertFalse(expectedValue.contains(lastname));
		
	}

}
