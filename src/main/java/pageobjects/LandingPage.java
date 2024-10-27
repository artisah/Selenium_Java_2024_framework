package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends AbstractComponents {
    private WebDriver driver;

    // Constructor
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Locators
    private By userEmailLocator = By.id("userEmail");
    private By passwordLocator = By.id("userPassword");
    private By submitLocator = By.id("login");
    private By errorMessageLocator = By.cssSelector("[class*='flyInOut']");


    public void navigateToApplication(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public ProductCatalog loginApplication(String email, String password) {
        WebElement userEmail = driver.findElement(userEmailLocator);
        WebElement passwordEle = driver.findElement(passwordLocator);
        WebElement submit = driver.findElement(submitLocator);

        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        return new ProductCatalog(driver);
    }

    public String getLoginErrorMessage() {
        waitForElementToAppear(errorMessageLocator);
        return driver.findElement(errorMessageLocator).getText();
    }


}
