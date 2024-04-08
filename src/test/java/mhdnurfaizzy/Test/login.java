package mhdnurfaizzy.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.SearchPage;
import mhdnurfaizzy.testComponent.baseTesting;

public class login extends baseTesting{
	
	@Test
	public void loginApp() {
	//Login
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
		System.out.println("Notif Pop up not shown");
	  }
	homePage.popUpAds();
	
	//Search Fitur
	SearchPage searchPage = new SearchPage(driver);
	String productTerkait = searchPage.verifyProductTerkait();
	Assert.assertTrue(productTerkait.equalsIgnoreCase("Produk Terkait"));
	searchPage.searchProduct();
	homePage.popUpAds();
	searchPage.goToFirstProduct();
		
	}
	

}
