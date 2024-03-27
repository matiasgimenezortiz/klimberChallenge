package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step5Page extends BasePage {

    @FindBy(id = "CardNumber")
    protected WebElement cardNumberField;

    @FindBy(id = "btnSubmitStep4")
    protected WebElement nextButton;

    public Step5Page(WebDriver driver) {
        super(driver);
    }

    public void setCardNumberField(String cardNumber) {
        this.cardNumberField.sendKeys(cardNumber);
    }

    public Step6Page clickNextButton() {
        wait.waitForElementToBeClickable(driver, nextButton, 5);
        nextButton.click();
        return new Step6Page(driver);
    }

    public void fillPaymentDetails(String cardNumber) {
        setCardNumberField(cardNumber);
    }

}
