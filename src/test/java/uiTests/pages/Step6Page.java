package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step6Page extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement nextButton;

    public Step6Page(WebDriver driver) {
        super(driver);
    }

    public SummaryPage clickNextButton() {
        wait.waitForElementToBeClickable(driver, nextButton, 5);
        nextButton.click();
        return new SummaryPage(driver);
    }
}
