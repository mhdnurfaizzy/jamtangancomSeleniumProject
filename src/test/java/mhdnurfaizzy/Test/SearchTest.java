package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.pageobjects.SearchPage;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SearchTest extends baseTesting {


    @Test(groups= {"Regression"})
    public void searchProduct() {

        //home page
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        //Search
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct();
    }

    //Section Search Bar - RelatedProduct, RecommendedProduct, BrandsProduct
    @Test()
    public void scrBarSection() {
        //home page
        HomePage homePage = new HomePage(driver);
        homePage.popUpAfterlogin();

        //Search
        SearchPage searchPage = new SearchPage(driver);

        String productRelatedString = searchPage.srcBarProductTerkait();
        Assert.assertTrue(productRelatedString.equalsIgnoreCase("Produk Terkait"));
        searchPage.clearSearch();

        String productRecomendString = searchPage.srcBarRecommendedProduct();
        Assert.assertTrue(productRecomendString.equalsIgnoreCase("Rekomendasi Series"));
        searchPage.clearSearch();

        String brandsString = searchPage.srcBarBrands();
        Assert.assertTrue(brandsString.equalsIgnoreCase("Brand"));
        searchPage.clearSearch();

    }
}
