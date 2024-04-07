package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class LoginPage extends abstractComponent{

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(css="input[name='username']")
	 WebElement useremail;
	
	//driver.findElement(By.id("userPassword")) 
	@FindBy(css="input[name='password']")
	 WebElement passwordEle;
	
	@FindBy(css=".mw-ripple-effect.btn.rounded.text-sm.relative.overflow-hidden.w-full.btn-filled.text-neutral-1000.bg-primary-1.uppercase.qa-login-button")
	 WebElement submit;
	
	public void goTo()
	{
		driver.get("https://www.jamtangan.com/login");
	}
	
	public void loginApplication() {
		useremail.sendKeys("mhdnurfaizzy@gmail.com");
		passwordEle.isDisplayed();
		passwordEle.sendKeys("Apaiya01-");
		submit.isEnabled();
		submit.click();
	
	}

}
