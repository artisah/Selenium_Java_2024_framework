package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductCatalog extends AbstractComponents {
    private WebDriver driver;

    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By products_list = By.cssSelector(".mb-3");
    private By addToCartBtn = By.cssSelector(".card-body button:last-of-type");
    private By productAddedMsg = By.cssSelector("#toast-container");

//    private By cartMenuOption = By.cssSelector("[routerlink*='cart']");


    public List<WebElement> getProductList() {
        waitForElementToAppear(products_list);
        List<WebElement> products = driver.findElements(products_list);
        return products;
    }

    public WebElement getProductByName(List<WebElement> products, String productName) {
        WebElement desiredProduct = products.stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        return desiredProduct;
    }

    public void addProductToCart(WebElement desiredProduct){
        desiredProduct.findElement(addToCartBtn).click();
        //Explicit wait- "Product added to cart message" is visisble then invsisble
        waitForElementToAppear(productAddedMsg);
        waitForElementToDisappear(productAddedMsg);

    }

//    public CartPage clickCartMenuOption(){
//        // Click Cart menu option
//        driver.findElement(cartMenuOption).click();
//        return new CartPage(driver);
//    }

//    public void addproductTocart() {
//        waitForElementToAppear(products_list);
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//        List<WebElement> products = driver.findElements(products_list);
//        //Each DIv find element with text = "ZARA COAT 3"
//        WebElement desiredProduct = products.stream().filter(product ->
//                product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//
//        // Click on Add to cart button for product = "ZARA COAT 3"
//        desiredProduct.findElement(addToCartBtn).click();
//
//        // Explicit wait- "Product added to cart message" is visisble then invsisble
//        waitForElementToAppear(productAddedMsg);
//        waitForElementToDisappear(productAddedMsg);
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
////        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
//
//        // Explict wait - cart menu option is clickable and visible
//        waitForElementToBeClickable(cartMenuOption)
//        waitForElementToAppear(cartMenuOption);
////        wait.until(ExpectedConditions.elementToBeClickable(cartMenuOption));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(cartMenuOption));
//
//        // Click Cart menu option
//        driver.findElement(cartMenuOption).click();
//
//    }
}
