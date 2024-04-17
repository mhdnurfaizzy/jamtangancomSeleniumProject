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

    @DataProvider
    public static Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "src/main/java/mhdnurfaizzy/data/Purchase.json");
        return new Object[][] { {data.get(0)} };
    }

    //Section Search Bar - RelatedProduct, RecommendedProduct, BrandsProduct
    @Test(dataProvider= "getData")
    public void scrBarSection(HashMap<String, String> input) {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication(input.get("email"), input.get("password"));

        //home page
        HomePage homePage = new HomePage(driver);
        try
        {
            // Some code
            homePage.alertNotif();
        }
        catch(Exception e)
        {
            // Code for Handling the exception
            System.out.println("Notification Pop up not shown");
        }
        try {
            homePage.popUpAds();
        }  catch(Exception e1)
            {
                System.out.println("Pop up Ads not shown");
            }

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
