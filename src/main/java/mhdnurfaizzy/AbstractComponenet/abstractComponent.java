package mhdnurfaizzy.AbstractComponenet;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.OrderPage;

public class abstractComponent {
	
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	 WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	 WebElement orderHeader;
	
	@FindBy(css="#desktopBannerWrapped > div")
	 WebElement notif;
	
	@FindBy(id="close-icon")
	 WebElement popUpAds;
	
	public abstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitElementForAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitWebElementForAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitElementUntillDissapear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	public HomePage alertNotif() {
		waitWebElementForAppear(notif);
		//close notif
		driver.findElement(By.cssSelector("#desktopBannerWrapped > div > div:nth-child(3) > div:nth-child(2) > button:nth-child(1)")).click();
		HomePage homepage = new HomePage(driver);
		return homepage;
	}
	
	public HomePage popUpAds() {
		WebElement iframe = driver.findElement(By.cssSelector("#moe-onsite-campaign-660b1c43c47fb6e58618110e"));
		driver.switchTo().frame(iframe);
		waitWebElementForAppear(driver.findElement(By.cssSelector("body > div > div.button-container.no-bounds")));
		waitWebElementForAppear(popUpAds);
		popUpAds.click();
		driver.switchTo().defaultContent();
		HomePage homepage = new HomePage(driver);
		return homepage;
	}

}
