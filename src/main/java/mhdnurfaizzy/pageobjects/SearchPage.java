package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class SearchPage extends abstractComponent{
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		//PageFactory
		@FindBy(css="input[placeholder='Cari di Jamtangan.com']")
		 WebElement searchBar;
		@FindBy(css=".ic-search.text-2xl")
		 WebElement searchIcon;
		@FindBy(css="div[class='text-primary-1 font-black text-sm']")
		 WebElement getProdukTerkaitText;
		@FindBy(css=".ic-close.text-2xl")
		 WebElement clearArea;
		@FindBy(xpath="(//div[@class='product-card relative'])[1]")
		 WebElement firstProduct;
		
		
		
	public void searchProduct() {
		searchBar.sendKeys("casio");
		searchIcon.click();
	}
	
	public String verifyProductTerkait() {
		searchBar.sendKeys("casio");
		waitWebElementForAppear(getProdukTerkaitText);
		clearArea.click();
		return getProdukTerkaitText.getText();
	}
	
	public void goToFirstProduct() {
		waitWebElementForAppear(firstProduct);
		firstProduct.click();
	}

}
