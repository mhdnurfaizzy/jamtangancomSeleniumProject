package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.CheckoutPage;
import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CheckoutPageTest  extends baseTesting {

    @Test(groups= {"Regression"})
    public void CheckOutPageTest() {
        //home page
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        //GoToCartPage
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        cartPage.verifyProductTitleDisplayed();
        cartPage.countAvailableProduct();

        //GoToCheckOutPage
        cartPage.goToCheckout();

        //CheckoutPage
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String shipAddress = checkoutPage.address();
        Assert.assertTrue(shipAddress.equalsIgnoreCase("Alamat Pengiriman"));
        checkoutPage.chooseShipOpt();


    }
}
