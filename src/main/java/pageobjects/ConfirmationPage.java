package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends AbstractComponents {
    private WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By confirmationTextUI = By.cssSelector(".hero-primary");

    public String getConfirmationText() {
        return driver.findElement(confirmationTextUI).getText();
    }
}
