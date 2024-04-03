package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends BasePage {

    @FindBy(id = "chkTC")
    protected WebElement check;

    @FindBy(id = "btnSummarySubmit")
    protected WebElement nextButton;

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void clickTermsCheck() {
        wait.waitForElementToBeClickable(driver, check, 5);
        check.click();
    }

    public LastPage clickNextButton() {
        wait.waitForElementToBeClickable(driver, nextButton, 5);
        nextButton.click();
        return new LastPage(driver);
    }

    public void acceptTermsAndConditions(){
        clickTermsCheck();
    }
}
