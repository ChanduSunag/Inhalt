/*package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.myriad.genericlibrary.ExcelLibrary;
import com.crm.myriad.genericlibrary.FileLibrary;
import com.crm.myriad.genericlibrary.WebDriverLibrary;

public class CreatePurchaseOrderWithVendorNameTest {

	public static void main(String[] args) throws Throwable {

		FileLibrary fLib=new FileLibrary();
		ExcelLibrary eLib=new ExcelLibrary();
		WebDriverLibrary wLib=new WebDriverLibrary();
		//FileInputStream fis=new FileInputStream("./testdata/commondata.properties");
		//Properties p=new Properties();
		//p.load(fis);
		String url = fLib.getPropertyKeyValue("url");
		String usn = fLib.getPropertyKeyValue("usn");
		String pwd = fLib.getPropertyKeyValue("pwd");

		WebDriver driver=new ChromeDriver();
		wLib.waitForElementInDOM(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(usn);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		//Actions a=new Actions(driver);
		WebElement more = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
		//a.moveToElement(more).perform();
		wLib.mouseOverOnElement(driver, more);
		driver.findElement(By.xpath("(//a[text()='Vendors'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		String vendername = eLib.getStringDataFromExcel("Sheet4", 1, 0);
		//FileInputStream fis1=new FileInputStream("./testdata/Exceldata.xlsx");
		//Workbook wb=WorkbookFactory.create(fis1);
		//String vendername = wb.getSheet("Sheet4").getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.name("vendorname")).sendKeys(vendername);
		driver.findElement(By.name("button")).click();

		WebElement more1 = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
		wLib.mouseOverOnElement(driver, more1);

		//a.moveToElement(more1).perform();

		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		String subject = eLib.getStringDataFromExcel("Sheet4", 1, 1);
		//String subject = wb.getSheet("Sheet4").getRow(1).getCell(1).getStringCellValue();

		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		String presentwindowtitle = eLib.getStringDataFromExcel("Sheet4", 1, 3);

		//String presentwindowtitle = wb.getSheet("Sheet4").getRow(1).getCell(3).getStringCellValue();

		wLib.swithToWindow(driver, presentwindowtitle);

		/*Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
		String wid = it.next();
		driver.switchTo().window(wid);
		String currentwindowtitle = driver.getTitle();
		if(currentwindowtitle.contains(presentwindowtitle))
		{
		break;
		}
		}*/
		/*driver.findElement(By.id("search_txt")).sendKeys(vendername);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();

		String parentbrowsertitle = eLib.getStringDataFromExcel("Sheet4", 1, 4);
		//String parentbrowsertitle = wb.getSheet("Sheet4").getRow(1).getCell(4).getStringCellValue();

		wLib.swithToWindow(driver, parentbrowsertitle);

		/*Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext())
		{
		String wid1 = it1.next();
		driver.switchTo().window(wid1);
		String currentbrowsertitle = driver.getTitle();
		if(currentbrowsertitle.contains(parentbrowsertitle))
		{
		break;
		}
		}*/
		/*String billadress = eLib.getStringDataFromExcel("Sheet4", 3, 1);
		String billpobox = eLib.getStringDataFromExcel("Sheet4", 4, 1);
		String billcity = eLib.getStringDataFromExcel("Sheet4", 5, 1);
		String billstate = eLib.getStringDataFromExcel("Sheet4", 6, 1);
		String billpostcode = eLib.getStringDataFromExcel("Sheet4", 7, 1);
		String billcountry = eLib.getStringDataFromExcel("Sheet4", 8, 1);

		//String billadress = wb.getSheet("Sheet4").getRow(3).getCell(1).getStringCellValue();
		//String billpobox = wb.getSheet("Sheet4").getRow(4).getCell(1).getStringCellValue();
		//String billcity = wb.getSheet("Sheet4").getRow(6).getCell(1).getStringCellValue();
		//String billstate = wb.getSheet("Sheet4").getRow(7).getCell(1).getStringCellValue();
		//String billpostcode = wb.getSheet("Sheet4").getRow(8).getCell(1).getStringCellValue();
		//String billcountry = wb.getSheet("Sheet4").getRow(9).getCell(1).getStringCellValue();

		/*driver.findElement(By.name("bill_street")).sendKeys(billadress);
		driver.findElement(By.id("bill_pobox")).sendKeys(billpobox);
		driver.findElement(By.id("bill_city")).sendKeys(billcity);
		driver.findElement(By.id("bill_state")).sendKeys(billstate);
		driver.findElement(By.id("bill_code")).sendKeys(billpostcode);
		driver.findElement(By.id("bill_country")).sendKeys(billcountry);
		driver.findElement(By.name("cpy")).click();
	}

}*/


