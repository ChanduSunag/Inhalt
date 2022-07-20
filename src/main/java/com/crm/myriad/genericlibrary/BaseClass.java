package com.crm.myriad.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.myriad.pomRepository.HomePage;
import com.crm.myriad.pomRepository.LoginPage;

public class BaseClass {


	public WebDriver driver;
	public static WebDriver sdriver;

	/*Object Creation for GenericLibrary*/
	WebDriverLibrary wLib = new WebDriverLibrary();
	FileLibrary fLib = new FileLibrary();

	//@Parameters("Browser")
	//Open the browser
	@BeforeClass(groups = {"Regression Test","Smoke Test"})
	public void LaunchTheBrowser(/*String Browser*/) throws Throwable {
		String Browser = fLib.getPropertyKeyValue("Browser");
		//String Browser = System.getProperty("BROWSER");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		//driver = new ChromeDriver();
		wLib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
		
		
	}



	//Login to Inhalt App
	@BeforeMethod(groups = {"Regression Test","Smoke Test"})
	public void LoginToApp() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("usn");
		String PASSWORD = fLib.getPropertyKeyValue("pwd");
		String URL = fLib.getPropertyKeyValue("url");
		/* step 1 : login */
		LoginPage lp=new LoginPage(driver);
		lp.loginToInhalt(URL, USERNAME, PASSWORD);
	}


	//Logout from Inhalt App
	@AfterMethod(groups = {"Regression Test","Smoke Test"})
	public void LogoutFromApp( ) {
		HomePage hp=new HomePage(driver);
		hp.logoutInhalt();
	}


	//Close all the Browser
	@AfterClass(groups = {"Regression Test","Smoke Test"})
	public void CloseTheBrowser() {
		driver.close();
	}

}
