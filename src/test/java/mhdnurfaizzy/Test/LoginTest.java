package mhdnurfaizzy.Test;

import mhdnurfaizzy.pageobjects.LoginPage;
import mhdnurfaizzy.testComponent.baseTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseTesting {

    @Test
    public void validLogin() {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication();
    }

    @Test
    public void invalidLogin() {
        //Login
        loginPage.invalidLogin();
        String errorMessage = loginPage.errMessage();
        Assert.assertTrue(errorMessage.equalsIgnoreCase("Ups, email atau password kamu salah"));

    }
}
