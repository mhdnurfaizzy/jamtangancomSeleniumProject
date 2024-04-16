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

	@FindBy(css=".message.text-xs.leading-normal.font-bold")
	WebElement errMessageLogin;

	
	public void goTo()
	{
		driver.get("https://www.jamtangan.com/login");
	}
	
	public void loginApplication(String email, String password) {
		useremail.sendKeys(email);
		passwordEle.isDisplayed();
		passwordEle.sendKeys(password);
		submit.isEnabled();
		submit.click();

	}
	public void invalidLogin(String email, String password) {
		useremail.sendKeys(email);
		passwordEle.isDisplayed();
		passwordEle.sendKeys(password);
		submit.isEnabled();
		submit.click();

	}

	public void invalidEmail(String email, String password) {
		useremail.sendKeys(email);
		passwordEle.isDisplayed();
		passwordEle.sendKeys(password);
		submit.isEnabled();
		submit.click();
	}

	public String errMessageWrongPass() {
		waitWebElementForAppear(errMessageLogin);
		return errMessageLogin.getText();
	}

	public String errMessageWrongEmail() {
		waitWebElementForAppear(errMessageLogin);
		return errMessageLogin.getText();
	}






}
