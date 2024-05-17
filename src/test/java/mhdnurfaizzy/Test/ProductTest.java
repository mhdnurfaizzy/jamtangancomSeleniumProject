package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.ProductPage;
import mhdnurfaizzy.pageobjects.SearchPage;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ProductTest extends baseTesting {


    @Test(groups= {"Regression"})
    public void addProductToCart() {
        //home page
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        //Search
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct();
        searchPage.goToFirstProduct();

        //ProductPage
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        productPage.getTextMessaggeAddToCart();



    }



}
