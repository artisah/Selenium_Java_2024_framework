package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage extends AbstractComponents {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By countryDropDownElement = By.cssSelector("input.text-validated[placeholder='Select Country']");
    private By countryDropDownItems = By.cssSelector(".ta-results");

    private By Counrty2Item  = By.xpath("//button[contains(@class, 'ta-item')][2]");

    private By placeOrderBtn = By.cssSelector(".action__submit");

    public void selectCountryFromDropDown(String country) {
        WebElement countryDropDown = driver.findElement(countryDropDownElement);
        Actions action = new Actions(driver);
        action.sendKeys(countryDropDown, country).build().perform();
        waitForElementToAppear(countryDropDownItems);
        // Finding Second Dropdown item. INDIa.not good code and click it
        driver.findElement(Counrty2Item).click();
    }

    public ConfirmationPage clickPlaceOrderBtn() {
        driver.findElement(placeOrderBtn).click();
        return new ConfirmationPage(driver);
    }
}
