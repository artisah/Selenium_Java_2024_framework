package abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CartPage;
import pageobjects.OrderPage;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
    }

    private By cartMenuOption = By.cssSelector("[routerlink*='cart']");
    private By orderMenuOption = By.cssSelector("[routerlink*='myorders']");

    public void waitForElementToAppear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public CartPage clickCartMenuOption(){
        // Explict wait - cart menu option is clickable and visible
        waitForElementToBeClickable(orderMenuOption);
        waitForElementToAppear(cartMenuOption);
        // Click Cart menu option
        driver.findElement(cartMenuOption).click();
        return new CartPage(driver);
    }

    public OrderPage clickOrderMenuOption(){
        // Explict wait - cart menu option is clickable and visible
        waitForElementToBeClickable(orderMenuOption);
        waitForElementToAppear(orderMenuOption);
        // Click Cart menu option
        driver.findElement(orderMenuOption).click();
        return new OrderPage(driver);
    }
}
