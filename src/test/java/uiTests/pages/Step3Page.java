package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Step3Page extends BasePage {

    @FindBy(id = "Name")
    protected WebElement nameField;

    @FindBy(id = "Surname")
    protected WebElement surnameField;

    @FindBy(id = "ID_Number")
    protected WebElement personalIdField;

    @FindBy(id = "Gender")
    protected WebElement genderDropdown;

    @FindBy(id = "IdentificationGenderType")
    protected WebElement identificationGenderDropdown;

    @FindBy(id = "CivilStatus")
    protected WebElement civilStatusDropdown;

    @FindBy(id = "txtEmail")
    protected WebElement emailField;

    @FindBy(id = "Password")
    protected WebElement passwordField;

    @FindBy(id = "Street")
    protected WebElement streetField;

    @FindBy(id = "HouseNumber")
    protected WebElement houseNumberField;

    @FindBy(id = "Floor")
    protected WebElement floorField;

    @FindBy(id = "Apartment")
    protected WebElement aptField;

    @FindBy(id = "zipCode")
    protected WebElement zipcodeField;

    @FindBy(id = "city")
    protected WebElement cityDropdown;

    @FindBy(id = "province")
    protected WebElement provinceDropdown;

    @FindBy(id = "country")
    protected WebElement countryDropdown;

    @FindBy(id = "btnRegister")
    protected WebElement nextButton;

    public Step3Page(WebDriver driver){
        super(driver);
    }

    public void setNameField(String name) {
        this.nameField.sendKeys(name);
    }

    public void setSurnameField(String surname) {
        this.surnameField.sendKeys(surname);
    }

    public void setPersonalIdField(String personalId) {
        this.personalIdField.sendKeys(personalId);
    }

    public void setGenderDropdown(String genderDropdown) {
        Select dropdownOptions = new Select(this.genderDropdown);
        dropdownOptions.selectByVisibleText(genderDropdown);

    }

    public void setIdentificationGenderDropdown(String identificationGenderDropdown) {
        Select dropdownOptions = new Select(this.identificationGenderDropdown);
        dropdownOptions.selectByVisibleText(identificationGenderDropdown);
    }

    public void setCivilStatusDropdown(String civilStatusDropdown) {
        Select dropdownOptions = new Select(this.civilStatusDropdown);
        dropdownOptions.selectByVisibleText(civilStatusDropdown);
    }

    public void setEmailField(String email) {
        this.emailField.sendKeys(email);
    }

    public void setPasswordField(String password) {
        this.passwordField.sendKeys(password);
    }

    public void setStreetField(String street) {
        this.streetField.sendKeys(street);
    }

    public void setHouseNumberField(String houseNumber) {
        this.houseNumberField.sendKeys(houseNumber);
    }

    public void setFloorField(String floor) {
        this.floorField.sendKeys(floor);
    }

    public void setAptField(String apt) {
        this.aptField.sendKeys(apt);
    }

    public void setZipcodeField(String zipcode) {
        this.zipcodeField.sendKeys(zipcode);
        wait.waitForElementToDisappear(driver, spinner, 5);
    }

    public void setCityDropdown(String cityDropdown) {
        wait.waitForElementToBeClickable(driver, this.cityDropdown, 5);
        Select dropdownOptions = new Select(this.cityDropdown);
        dropdownOptions.selectByVisibleText(cityDropdown);
    }

    public void setProvinceDropdown(String provinceDropdown) {
        Select dropdownOptions = new Select(this.provinceDropdown);
        dropdownOptions.selectByVisibleText(provinceDropdown);
    }

    public void setCountryDropdown(String countryDropdown) {
        Select dropdownOptions = new Select(this.countryDropdown);
        dropdownOptions.selectByVisibleText(countryDropdown);
    }

    public Step4Page clickNextButton() {
        wait.waitForElementToBeClickable(driver, nextButton, 5);
        nextButton.click();
        return new Step4Page(driver);
    }

    public void fillPersonalDetails(String name, String surname, String personalId,
                                    String genderDropdown, String identificationGenderDropdown,
                                    String civilStatusDropdown, String email, String password) {
        setNameField(name);
        setSurnameField(surname);
        setPersonalIdField(personalId);
        setGenderDropdown(genderDropdown);
        setIdentificationGenderDropdown(identificationGenderDropdown);
        setCivilStatusDropdown(civilStatusDropdown);
        setEmailField(email);
        setPasswordField(password);
    }

    public void fillAddressDetails(String street, String houseNumber, String floor,
                                   String atp, String zipCode, String cityName){
        setStreetField(street);
        setHouseNumberField(houseNumber);
        setFloorField(floor);
        setAptField(atp);
        setZipcodeField(zipCode);
        setCityDropdown(cityName);
    }

    public static String generateRandomNumberID() {
        Random random = new Random();
        int randomNumber = random.nextInt(99999999) + 1;
        String formattedNumber = String.format("%08d", randomNumber);
        return formattedNumber;
    }

    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] prefixes = {"john", "emma", "michael", "sophia", "alex", "olivia", "david", "emily"};

        Random random = new Random();
        String domain = domains[random.nextInt(domains.length)];
        String prefix = prefixes[random.nextInt(prefixes.length)];

        int randomNumber = random.nextInt(99999);
        String email = prefix + randomNumber + "@" + domain;
        return email;
    }
}
