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
	
	
	public String verifyPaymentPage() {
		waitWebElementForAppear(paymentMethod);
		return paymentMethod.getText();
	}

}
