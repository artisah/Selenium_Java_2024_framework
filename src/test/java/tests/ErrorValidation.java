package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.ProductCatalog;
import testcomponents.BaseTest;
import testcomponents.Retry;

import java.io.IOException;
import java.util.List;


public class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void loginErrorValidation() throws IOException {
        landingPage.loginApplication("anita345@gmailwrong.com", "Selenium@123");
        Assert.assertEquals("Incorrect email or password.", landingPage.getLoginErrorMessage());
    }
    @Test(retryAnalyzer = Retry.class)
    public void loginWithInvalidDetails(){
        landingPage.loginApplication("anita345@gmailwrong.com", "Selenium@123");
        Assert.assertEquals("Login Successfull.", landingPage.getLoginErrorMessage()); // making actual error message wrong to fail tests

    }
}