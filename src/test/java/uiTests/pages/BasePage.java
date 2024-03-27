package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumutils.Waits;

public abstract class BasePage {

    protected WebDriver driver;
    protected Actions actions;
    protected Waits wait = new Waits();

    @FindBy(xpath = "//span[@class='logo-image']")
    protected WebElement loadedElement;
    @FindBy(xpath = "//div[@class ='modal in']")
    protected WebElement spinner;

    public BasePage(WebDriver driver) {
        setDriver(driver);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public boolean isLoaded() {
        wait.waitForElementToBeVisible(driver, loadedElement, 5);
        return loadedElement.isDisplayed();
    }

}
