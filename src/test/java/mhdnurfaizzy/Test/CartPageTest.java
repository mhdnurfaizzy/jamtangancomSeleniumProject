package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.CartPage;
import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CartPageTest extends baseTesting {
//    CartPage cartPage = new CartPage(driver);

    @Test(groups= {"Regression"})
    public void goToCartPage() {
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
    }

    @Test
    public void wishlistProductOnCart() {
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        cartPage.wishlist();
    }

    @Test
    public void addQty() {
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        cartPage.addQty();
    }

    @Test
    public void minQty() {
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        cartPage.minQty();
    }

    @Test
    public void checkTotalBelanja() {
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCartPage();
        cartPage.setTotalBelanja();
    }

}
