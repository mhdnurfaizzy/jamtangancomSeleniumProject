package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.*;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PaymentPageTest extends baseTesting {

    @DataProvider
    public static Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "src/main/java/mhdnurfaizzy/data/Purchase.json");
        return new Object[][] { {data.get(0)} };
    }

    @Test(dataProvider= "getData",groups= {"Regression"})
    public void CheckOutPageTest(HashMap<String, String> input) {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication(input.get("email"), input.get("password"));

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

        //GoToPaymentPage
        checkoutPage.goToPaymentPage();

        //PaymentPage
        PaymentPage paymentPage = new PaymentPage(driver);
        String payMethodString = paymentPage.verifyPaymentPage();
        Assert.assertTrue(payMethodString.equalsIgnoreCase("Metode Pembayaran"));
        paymentPage.methodVA();


    }
}