package mhdnurfaizzy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends abstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="button[data-testid='cart-btn-summary-cta']")
	 WebElement checkoutEle;
	@FindBy(css="div[class='block']")
	WebElement productTitle;
	@FindBy(css="#cart-item-0")
	WebElement product;
	@FindBy(css="span[data-testid='cart-list-item-wishlist']")
	WebElement btnWishlist;
	@FindBy(css="#cart-item-0 > div.mx-4.md\\:ml-4.md\\:mr-6.pb-6.md\\:pb-0 > div.mt-6 > div > span.ic-heart-fill.text-2xl.mr-4.cursor-pointer.text-primary-1")
	WebElement unWishlist;
	@FindBy(css=".ic-plus.text-neutral-300")
	WebElement plusQty;



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

	public void wishlist() {
		boolean wishlist = btnWishlist.isDisplayed();

		waitElementClickable(btnWishlist);
		btnWishlist.click();
		System.out.println("success wishlist product");
//		if (wishlist) {
//			System.out.println("no product on cart");
//		}else {
//			btnWishlist.click();
//			System.out.println("success wishlist product");
//		}
	}

	public void addQty() {
		waitWebElementForAppear(plusQty);
		plusQty.click();
	}
}
