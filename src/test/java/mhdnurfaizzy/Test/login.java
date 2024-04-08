package mhdnurfaizzy.Test;


import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.SearchPage;
import mhdnurfaizzy.testComponent.baseTesting;

public class login extends baseTesting{
	
	@Test
	public void loginApp() {
	
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginApplication();
	HomePage homePage = new HomePage(driver);
	try
	   {
	     // Some code
		homePage.alertNotif();
	   }
	catch(Exception e)
	  {
	     // Code for Handling the exception
		System.out.println("Notif not shown");
	  }
	homePage.popUpAds();
	SearchPage searchPage = new SearchPage(driver);
	searchPage.searchProduct();
	homePage.popUpAds();

		
	}
	

}
