package uiTests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class HomePage extends BasePage{


    @FindBy(xpath = "//*[@id='BirthdayStep1']")
    protected WebElement dateInputField;

    @FindBy(xpath = "//*[@id='province']")
    protected WebElement provinceDropdown;

    @FindBy(id = "txtPhoneCode")
    protected WebElement areaCode;

    @FindBy(id = "txtPhoneNumber")
    protected WebElement localNumber;

    @FindBy(xpath = "//div[@class='slider-handle min-slider-handle round']")
    protected WebElement sliderHandler;

    @FindBy(id = "btnSaveStep1")
    protected WebElement contratarButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded(){
        return loadedElement.isDisplayed();
    }

    public void setBirthday(String birthday) {
        dateInputField.sendKeys(birthday);
    }

    public void setProvinceDropdown(String provinceName) {
        Select dropdownOptions = new Select(provinceDropdown);
        dropdownOptions.selectByVisibleText(provinceName);
    }

    public void setAreaCode(String areaCode) {
        this.areaCode.sendKeys(areaCode);
    }
    public void setLocalNumber(String localNumber) {
        this.localNumber.sendKeys(localNumber, Keys.ENTER);
        wait.waitForElementToDisappear(driver, spinner, 5);
    }

    public void moveSliderRandomly() {
        actions.clickAndHold(sliderHandler).build().perform();

        Random random = new Random();
        int xOffset = random.nextInt(230) ; // Generates a random integer between 0 and 230
        actions.moveByOffset(xOffset, 0).build().perform();

        actions.release().build().perform();
        wait.waitForElementToDisappear(driver, spinner, 5);
    }

    public Step2Page clickContratarButton() {
        wait.waitForElementToBeClickable(driver, contratarButton, 5);
        contratarButton.click();
        return new Step2Page(driver);
    }

    public void fillPersonalInfo(String birthday, String province, String areaCode, String localNumber) {
        setBirthday(birthday);
        setProvinceDropdown(province);
        setAreaCode(areaCode);
        setLocalNumber(localNumber);
    }

}