package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage extends AbstractComponents {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By ProductOrderProductName = By.cssSelector("tr td:nth-child(3)");

    public Boolean orderDisplayed(String productName) {
        clickOrderMenuOption();
        List<WebElement> productNames = driver.findElements(ProductOrderProductName);
        Boolean isItemFoundInProductPage = productNames.stream().anyMatch(productNM -> productNM.getText().equalsIgnoreCase(productName));
        return isItemFoundInProductPage;
    }

}
