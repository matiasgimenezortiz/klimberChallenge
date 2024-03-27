package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step2Page extends BasePage {

    @FindBy(id = "txtHeight")
    protected WebElement height;

    @FindBy(id = "txtWeight")
    protected WebElement weight;

    @FindBy(id = "btnSaveStep2")
    protected WebElement nextButton;

    public Step2Page(WebDriver driver) {
        super(driver);
    }

    public void setHeight(String height) {
        this.height.sendKeys(height);
    }

    public void setWeight(String weight) {
        this.weight.sendKeys(weight);
    }

    public Step3Page clickNextButton() {
        wait.waitForElementToBeClickable(driver, nextButton, 5);
        nextButton.click();
        return new Step3Page(driver);
    }

    public void fillPhysicalInfo(String height, String weight) {
        setHeight(height);
        setWeight(weight);
    }
}
