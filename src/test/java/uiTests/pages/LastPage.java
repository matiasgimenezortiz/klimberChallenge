package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LastPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"frmSummary\"]//div[contains(text(),'Felicitaciones')]")
    WebElement congratsText;

    public LastPage(WebDriver driver){
        super(driver);
    }

    public boolean congratsTextIsShown() {
        wait.waitForElementToBeVisible(driver, congratsText, 5);
        return loadedElement.isDisplayed();
    }

}
