package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.HomePage;
import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends baseTesting {

    @DataProvider
    public static Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getDataJsonToMap(System.getProperty("user.dir") + "src/main/java/mhdnurfaizzy/data/Purchase.json");
        return new Object[][] { {data.get(0)} };
    }


    @Test(dataProvider= "getData",groups= {"Regression"})
    public void validLogin(HashMap<String, String> input) {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication(input.get("email"), input.get("password"));
    }

    @Test
    public void invalidLogin() {
        //Login
        loginPage.invalidLogin("mhdnurfaizzy@gmail.com", "Testing890-");
        String errorMessage = loginPage.errMessageWrongPass();
        Assert.assertTrue(errorMessage.equalsIgnoreCase("Ups, email atau password kamu salah"));
    }

    @Test
    public void invalidEmailLogin() {
        //Login
        loginPage.invalidEmail("mhdnurfaizi@gmail.com", "Testing890-");
        String errorMessage = loginPage.errMessageWrongPass();
        Assert.assertTrue(errorMessage.equalsIgnoreCase("Ups, akun ini belum terdaftar"));
    }


}
