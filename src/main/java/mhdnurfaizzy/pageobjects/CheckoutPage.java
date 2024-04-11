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
	
	@FindBy(css=".action__submit")
	 WebElement submit;
	
	@FindBy(css="input[placeholder='Select Country']")
	 WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	 WebElement selectCountry;
	@FindBy(css="div[class='bg-neutral-900 p-4 md:p-6 md:rounded-2'] span:nth-child(2)")
	 WebElement addressTitle;
	@FindBy(css="button[aria-label='Choose shipping method']")
	 WebElement shipOpt;
	@FindBy(xpath="(//li[@class='text-neutral-0 cursor-pointer py-4 pr-2 md:p-4 border-neutral-700 border-b-1 md:rounded-t-2 shippingItem'])[1]")
	 WebElement firstKurir;
	@FindBy(css=".mw-ripple-effect.btn.rounded.text-sm.relative.overflow-hidden.w-full.btn-filled.text-neutral-1000.bg-primary-1.uppercase")
	 WebElement btnGotoPayment;
	
	
	By result = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitElementForAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
//		waitWebElementForAppear(submit);
        Actions b = new Actions(driver);
        b.scrollToElement(submit).perform();
		submit.click();
		return new ConfirmationPage(driver);
	}
	
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
