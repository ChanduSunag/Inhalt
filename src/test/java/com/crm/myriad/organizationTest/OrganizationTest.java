package com.crm.myriad.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.myriad.genericlibrary.BaseClass;
import com.crm.myriad.genericlibrary.ExcelLibrary;
import com.crm.myriad.genericlibrary.JavaLibrary;
import com.crm.myriad.genericlibrary.WebDriverLibrary;
import com.crm.myriad.pomRepository.CreatingNewOrganizationPage;
import com.crm.myriad.pomRepository.HomePage;
import com.crm.myriad.pomRepository.OrganizationInformationPage;
import com.crm.myriad.pomRepository.OrganizationsPage;

public class OrganizationTest extends BaseClass{

	@Test(groups = "Smoke Test")
	public void CreateOrganizationTest() throws Throwable {
		
		JavaLibrary jLib=new JavaLibrary();
		ExcelLibrary eLib=new ExcelLibrary();
		WebDriverLibrary wLib=new WebDriverLibrary();
		wLib.waitForElementInDOM(driver);

		HomePage hp=new HomePage(driver);
		OrganizationsPage op=new OrganizationsPage(driver);
		CreatingNewOrganizationPage nop=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		int randomNum = jLib.getRandomNumber();
		hp.getOrganizationmodule().click();
		op.getOrgimgbox().click();
		String actualtext = eLib.getStringDataFromExcel("OrganizationData", 1, 0);
		nop.getOrgname().sendKeys(actualtext+randomNum);
		nop.getSave().click();

		String expectedtext = oip.getOrgimgbox().getText();
		Assert.assertTrue(expectedtext.contains(actualtext));

	}

}
