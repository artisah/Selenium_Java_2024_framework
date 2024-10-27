package tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;
import testcomponents.BaseTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TestClass1 extends BaseTest {
    String productname = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void createOrder(HashMap<String,String> input) throws IOException {

        ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));

        //Product page
        List<WebElement> products = productCatalog.getProductList();
        WebElement desiredProduct = productCatalog.getProductByName(products, productname);
        productCatalog.addProductToCart(desiredProduct);
        CartPage cartpage = productCatalog.clickCartMenuOption();

        //Cart Page
        Boolean isItemFoundInCart = cartpage.verifyProductDisplay(productname);
        Assert.assertTrue(isItemFoundInCart);
        // Click checkout button on Cart page
        CheckoutPage checkoutPage = cartpage.clickCheckoutBtn();

//      CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCountryFromDropDown("india");
        ConfirmationPage confirmationPage = checkoutPage.clickPlaceOrderBtn();

//       ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmText = confirmationPage.getConfirmationText();

        // Selenium checks text displayed in Ui and not in HTML DOM
        Assert.assertTrue(confirmText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"createOrder"})
    public void OrderHistoryTest() {
        ProductCatalog productCatalog = landingPage.loginApplication("anita345@gmail.com", "Selenium@123");
        OrderPage orderPage = productCatalog.clickOrderMenuOption();
        Boolean isItemFoundInProductPage = orderPage.orderDisplayed(productname);
        Assert.assertTrue(isItemFoundInProductPage);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
         List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//purchaseorder.json");

        return new Object[][] {{data.get(0)}, {data.get(1)}};
}


//    @DataProvider
//    public Object[][] getData() {
//        return new Object[][] {
//                {"anita345@gmail.com", "Selenium@123"},
//                {"dummy345@gmail.com", "Selenium@123"}
//        };
//    }





//        below code without Page Object

//        driver.findElement(By.id("userEmail")).sendKeys("anita345@gmail.com");
//        driver.findElement(By.id("userPassword")).sendKeys("Selenium@123");
//        driver.findElement(By.id("login")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        //Select All Items : Div
//        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//
//        //Each DIv find element with text = "ZARA COAT 3"
//        WebElement desiredProduct = products.stream().filter(product ->
//                product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//
//        // Click on Add to cart button for product = "ZARA COAT 3"
//        desiredProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        // Explicit wait- "Product added to cart message" is visisble then invsisble
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));

//        // Explict wait - cart menu option is clickable and visible
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[routerlink*='cart']")));
//
//        // Click Cart menu option
//        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        // In cart page verify "ZARA COAT 3" is added to cart
        // AnyMatch returns Boolean
//        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
//        Boolean isItemFoundInCart = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productname));
//        Assert.assertTrue(isItemFoundInCart);

        // Click on Checkout button
//        driver.findElement(By.cssSelector(".totalRow button")).click();

//        // In checkout page enter country
//        driver.findElement(By.cssSelector("input.text-validated[placeholder='Select Country']")).sendKeys("india");
//
//        // get all Country drop down option having word "India"
//        List<WebElement> countrydropDownOptions = driver.findElements(By.cssSelector("section.ng-star-inserted button"));
//
//        WebElement CountryOptionToSelect = countrydropDownOptions.stream()
//                .filter(countrydropDownOption -> countrydropDownOption.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
//        CountryOptionToSelect.click();

        //Using Action Classes
//        WebElement countryDropDown = driver.findElement(By.cssSelector("input.text-validated[placeholder='Select Country']"));
//        Actions action = new Actions(driver);
//        action.sendKeys(countryDropDown, "India").build().perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//
//        // Finding Second Dropdown item. INDIa.not good code and click it
//        driver.findElement(By.xpath("//button[contains(@class, 'ta-item')][2]")).click();
//
//        //Click on Place order button
//        driver.findElement(By.cssSelector(".action__submit")).click();

        // get Text " Thankyou for the order. " from checkout page
//        String confirmText = driver.findElement(By.cssSelector(".hero-primary")).getText();
//        // Selenium checks text displayed in Ui and not in HTML DOM
//        Assert.assertTrue(confirmText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//        driver.close();
//    }

}
