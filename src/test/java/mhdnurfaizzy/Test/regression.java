package mhdnurfaizzy.Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.PaymentDetailsPage;
import mhdnurfaizzy.pageobjects.PaymentPage;
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
	
	//CheckoutPage
	CheckoutPage checkoutPage = new CheckoutPage(driver);
	cartPage.goToCheckout();
	String shipAddress = checkoutPage.address();
	Assert.assertTrue(shipAddress.equalsIgnoreCase("Alamat Pengiriman"));
	checkoutPage.chooseShipOpt();
	
	//PaymentPage
	checkoutPage.goToPaymentPage();
	PaymentPage paymentPage = new PaymentPage(driver);
	String payMethodString = paymentPage.verifyPaymentPage();
	Assert.assertTrue(payMethodString.equalsIgnoreCase("Metode Pembayaran"));
	paymentPage.methodVA();
	
	//ThankYouPage
	paymentPage.orderNow();
	PaymentDetailsPage payDetails = new PaymentDetailsPage(driver);
	System.out.println(payDetails.noVA());
	
	}
	
}
