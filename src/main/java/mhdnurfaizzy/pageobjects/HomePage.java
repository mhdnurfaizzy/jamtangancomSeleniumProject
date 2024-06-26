package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class HomePage extends abstractComponent{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void popUpAfterlogin() {
		try
		{
			// Some code
			alertNotif();
		}
		catch(Exception e)
		{
			// Code for Handling the exception
			System.out.println("Notification Pop up not shown");
		}
		try {
			popUpAds();
		}  catch(Exception e1)
		{
			System.out.println("Pop up Ads not shown");
		}
	}
	

}
