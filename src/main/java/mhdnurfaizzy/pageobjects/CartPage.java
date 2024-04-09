package mhdnurfaizzy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class CartPage extends abstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	 WebElement checkoutEle;
	
	@FindBy(css="div[class='block']")
	WebElement productTitle;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProductTitleDisplayed() {
		waitWebElementForAppear(productTitle);
		productTitle.isDisplayed();
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
}
