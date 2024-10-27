package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CartPage extends AbstractComponents {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By cartProductName = By.cssSelector(".cartSection h3");
    private By checkoutBtn = By.cssSelector(".totalRow button");
    public Boolean verifyProductDisplay(String productName){
        List<WebElement> cartItems = driver.findElements(cartProductName);
        Boolean isItemFoundInCart = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
        return isItemFoundInCart;
    }

    public CheckoutPage clickCheckoutBtn(){
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
