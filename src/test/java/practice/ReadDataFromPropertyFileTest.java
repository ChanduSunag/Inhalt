package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String usn = p.getProperty("usn");
		String pwd = p.getProperty("pwd");

		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(usn);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		driver.close();

	}

}
