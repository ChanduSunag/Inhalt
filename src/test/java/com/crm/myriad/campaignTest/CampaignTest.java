package com.crm.myriad.campaignTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.myriad.genericlibrary.BaseClass;
import com.crm.myriad.genericlibrary.ExcelLibrary;
import com.crm.myriad.genericlibrary.JavaLibrary;
import com.crm.myriad.genericlibrary.WebDriverLibrary;
import com.crm.myriad.pomRepository.CampaignInformationPage;
import com.crm.myriad.pomRepository.CampaignsPage;
import com.crm.myriad.pomRepository.CreatingNewCampaignPage;
import com.crm.myriad.pomRepository.CreatingNewProductPage;
import com.crm.myriad.pomRepository.HomePage;
import com.crm.myriad.pomRepository.ProductsPage;

public class CampaignTest extends BaseClass{


	@Test(groups = "Smoke Test")
	public void CreateCampaignTest () throws Throwable {

		JavaLibrary jLib=new JavaLibrary();
		WebDriverLibrary wLib=new WebDriverLibrary();
		ExcelLibrary eLib=new ExcelLibrary();
		HomePage hp=new HomePage(driver);
		CampaignsPage cp=new CampaignsPage(driver);
		CreatingNewCampaignPage cnc=new CreatingNewCampaignPage(driver);
		String cmpName = eLib.getStringDataFromExcel("CampaignData", 1 , 0);
		int randomNum = jLib.getRandomNumber();
		WebElement resource = hp.getMoreOpt();
		wLib.mouseOverOnElement(driver, resource);
		hp.getCampaignmodule().click();
		cp.getCreateButton().click();
		cnc.getCampNameField().sendKeys(cmpName+randomNum);
		cnc.getSaveButton().click();

	}


	@Test(groups = "Regression Test")
	public void CreateCampaignWithProductTest () throws Throwable {

		JavaLibrary jLib=new JavaLibrary();
		ExcelLibrary eLib=new ExcelLibrary(); 
		WebDriverLibrary wLib=new WebDriverLibrary();
		HomePage hp=new HomePage(driver);
		ProductsPage pp=new ProductsPage(driver);
		CreatingNewProductPage cnp=new CreatingNewProductPage(driver);
		CampaignsPage cp=new CampaignsPage(driver);
		CreatingNewCampaignPage cncp=new CreatingNewCampaignPage(driver);
		CampaignInformationPage cip=new CampaignInformationPage(driver);
		int randomNum = jLib.getRandomNumber();

		String Title = eLib.getStringDataFromExcel("CampaignData", 0, 1);

		hp.getProductmodule().click();
		pp.getCreateproductimg().click();
		String productName = eLib.getStringDataFromExcel("ProductData", 1, 0);
		cnp.getProductname().sendKeys(productName+randomNum);
		cnp.getSave().click();
		WebElement resource = hp.getMoreOpt();
		wLib.mouseOverOnElement(driver, resource);
		hp.getCampaignmodule().click();
		cp.getCreateButton().click();
		String cmpName = eLib.getStringDataFromExcel("CampaignData", 1, 0);
		cncp.getCampNameField().sendKeys(cmpName+randomNum);

		cncp.getAddProcduct().click();
		String parentWindow = driver.getTitle();

		wLib.swithToWindow(driver, Title);
		pp.getSearchtext().sendKeys(productName+randomNum);
		pp.getSubmit().click();
		pp.getSelectProduct().click();

		wLib.swithToWindow(driver, parentWindow);
		cncp.getSaveButton().click();
		String actualData = cip.getVerifyCmp().getText();
		Assert.assertTrue(actualData.contains(cmpName));

	}

}
