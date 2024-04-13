package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class PaymentDetailsPage extends abstractComponent  {
	WebDriver driver;
	
	public PaymentDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='text-base text-primary-1 tracking-wide font-black md:font-bold leading-6 md:text-3xl']")
	WebElement vaNumber;
	
	public String noVA() {
		waitWebElementForAppear(vaNumber);
		return vaNumber.getText();
	}
}
