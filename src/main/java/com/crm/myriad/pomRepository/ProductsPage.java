package com.crm.myriad.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.myriad.genericlibrary.WebDriverLibrary;

public class ProductsPage extends WebDriverLibrary {

	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createproductimg;

	@FindBy(name="search_text")
	private WebElement searchtext;

	@FindBy(id="bas_searchfield")
	private WebElement searchfield;

	@FindBy(name="search")
	private WebElement submit;

	@FindBy (xpath= "(//a[@href='javascript:window.close();'])[1]")
	private WebElement selectProduct;

	public WebElement getCreateproductimg() {
		return createproductimg;
	}
	public WebElement getSearchtext() {
		return searchtext;
	}
	public WebElement getSearchfield() {
		selectByValue(searchfield, "lastname");
		return searchfield;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}

}
