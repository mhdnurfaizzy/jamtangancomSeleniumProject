package mhdnurfaizzy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class CartPage extends abstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="button[data-testid='cart-btn-summary-cta']")
	 WebElement checkoutEle;
	@FindBy(css="div[class='block']")
	WebElement productTitle;
	@FindBy(css="#cart-item-0")
	WebElement product;


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

	public void countAvailableProduct() {
		List<WebElement> availProduct = driver.findElements(By.cssSelector("div[class*='bg-neutral-900 md:rounded-2 text-neutral-300 pt-6 border-neutral-800']"));
		System.out.println("Product on cart : " + availProduct.size());
	}
}
