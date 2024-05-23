package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class CheckoutPage extends abstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div[class='bg-neutral-900 p-4 md:p-6 md:rounded-2'] span:nth-child(2)")
	 WebElement addressTitle;
	@FindBy(css="button[aria-label='Choose shipping method'] div[class='flex items-center']")
	 WebElement shipOpt;
	@FindBy(xpath="(//li[@class='text-neutral-0 cursor-pointer py-4 pr-2 md:p-4 border-neutral-700 border-b-1 md:rounded-t-2 shippingItem'])[1]")
	 WebElement firstKurir;
	@FindBy(css=".mw-ripple-effect.btn.rounded.text-sm.relative.overflow-hidden.w-full.btn-filled.text-neutral-1000.bg-primary-1.uppercase")
	 WebElement btnGotoPayment;
	
	
	By result = By.cssSelector(".ta-results");

	
	public String address() {
		waitWebElementForAppear(addressTitle);
		return addressTitle.getText();
		
	}
	
	public void chooseShipOpt() {
		shipOpt.click();
		waitWebElementForAppear(firstKurir);
		firstKurir.click();
	}
	
	public PaymentPage goToPaymentPage() {
		waitWebElementForAppear(btnGotoPayment);
		btnGotoPayment.click();
		return new PaymentPage(driver);
	}
	

}
