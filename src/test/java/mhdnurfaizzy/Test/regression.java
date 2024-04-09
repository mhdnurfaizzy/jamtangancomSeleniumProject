package mhdnurfaizzy.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.ProductPage;
import mhdnurfaizzy.pageobjects.SearchPage;
import mhdnurfaizzy.testComponent.baseTesting;

public class regression extends baseTesting{
	
	@Test
	public void Regression() {
	//Login
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginApplication();
	
	//Home Page
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
	
	//Search Feature
	SearchPage searchPage = new SearchPage(driver);
	String productTerkait = searchPage.verifyProductTerkait();
	Assert.assertTrue(productTerkait.equalsIgnoreCase("Produk Terkait"));
	searchPage.searchProduct();
	homePage.popUpAds();
	searchPage.goToFirstProduct();
	
	//ProductPage
	ProductPage productPage = new ProductPage(driver);
	productPage.addProductToCart();
	String textMessageSuccessATC = productPage.getTextMessaggeAddToCart();
	Assert.assertTrue(textMessageSuccessATC.equalsIgnoreCase("Sukses menambahkan produk ke keranjang"));
	
	//Cart Page
	CartPage cartPage = new CartPage(driver);
	cartPage.goToCartPage();
	cartPage.verifyProductTitleDisplayed();

	
		
	}
	

}
