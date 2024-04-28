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
		@FindBy(css="span[class='text-primary-1 font-black text-sm']")
		WebElement getRecommendedProductText;
		@FindBy(css="div[class='text-primary-1 font-black text-sm px-4 md:px-0']")
		WebElement getBrandsText;
		@FindBy(css="#reset-search")
		 WebElement clearArea;
		@FindBy(xpath="(//div[@class='relative px-2.5 pt-9 md:pt-8 md:px-4'])[1]")
		 WebElement firstProduct;
		
		
		
	public void searchProduct() {
		searchBar.sendKeys("casio");
		searchIcon.click();
	}
	
	public String srcBarProductTerkait() {
		waitWebElementForAppear(searchBar);
		searchBar.sendKeys("casio");
		waitWebElementForAppear(getProdukTerkaitText);
		return getProdukTerkaitText.getText();
	}

	public String srcBarRecommendedProduct() {
		searchBar.sendKeys("casio");
		waitWebElementForAppear(getRecommendedProductText);
		return getRecommendedProductText.getText();
	}

	public String srcBarBrands() {
		searchBar.sendKeys("casio");
		waitWebElementForAppear(getBrandsText);
		return getBrandsText.getText();
	}
	
	public void goToFirstProduct() {
		waitWebElementForAppear(firstProduct);
		firstProduct.click();
	}

	public void clearSearch() {
		waitWebElementForAppear(clearArea);
		clearArea.click();
	}

}
