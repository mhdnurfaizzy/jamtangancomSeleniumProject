package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class PaymentPage extends abstractComponent {
	
WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='text-primary-2 font-black text-sm flex items-center']")
	WebElement paymentMethod;
	@FindBy(css="div[data-testid='payment-item-VirtualAccount']")
	WebElement virtualAccount;
	@FindBy(css=".ic-check.text-xxs.text-neutral-1000.absolute.top-0.right-0")
	WebElement selectedMethod;
	@FindBy(css=".mw-ripple-effect.btn.rounded.text-sm.relative.overflow-hidden.w-full.btn-filled.text-neutral-1000.bg-primary-1.uppercase")
	WebElement orderNow;
	
	public String verifyPaymentPage() {
		waitWebElementForAppear(paymentMethod);
		return paymentMethod.getText();
	}
	
	public void methodVA() {
		waitWebElementForAppear(virtualAccount);
		virtualAccount.click();
		waitWebElementForAppear(selectedMethod);
		selectedMethod.isDisplayed();
	}
	
	public PaymentDetailsPage orderNow() {
		waitWebElementForAppear(orderNow);
		orderNow.isEnabled();
		orderNow.click();
		return new PaymentDetailsPage(driver);
	}

}
