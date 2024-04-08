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
		
		
	public HomePage searchProduct() {
		searchBar.sendKeys("casio");
		searchIcon.click();
		return new HomePage(driver);
	}

}
