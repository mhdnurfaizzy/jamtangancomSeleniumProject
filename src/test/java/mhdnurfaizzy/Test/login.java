package mhdnurfaizzy.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.testComponent.baseTest;
import mhdnurfaizzy.testComponent.baseTesting;

public class login extends baseTesting{
	
	
	
	@Test
	public void loginApp() {
	
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginApplication();
	driver.getTitle();
	HomePage homePage = new HomePage(driver);
	homePage.alertNotif();
	homePage.popUpAds();
		
	}
	

}
