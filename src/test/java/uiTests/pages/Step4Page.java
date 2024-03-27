package uiTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Step4Page extends BasePage {

    @FindBy(id = "Nationality")
    protected WebElement nationalityField;

    @FindBy(id = "PlaceOfBirth")
    protected WebElement placeOfBirthField;

    @FindBy(id = "txtOccupation")
    protected WebElement occupationField;

    @FindBy(id = "txtSalaryAnual")
    protected WebElement salaryField;

    @FindBy(id = "txtAnnualIncome")
    protected WebElement salaryIncomeDropdown;

    @FindBy(id = "txtFullName")
    protected WebElement partnerNameField;

    @FindBy(id = "txtNumberId")
    protected WebElement partnerIdField;


    @FindBy(id = "btnSaveInfo")
    protected WebElement nextButton;

    public Step4Page(WebDriver driver) {
        super(driver);
    }

    public void setNationalityField(String nationality) {
        Select dropdownOptions = new Select(this.nationalityField);
        dropdownOptions.selectByVisibleText(nationality);
    }
    public void setPlaceOfBirthField(String placeOfBirthField) {
        this.placeOfBirthField.sendKeys(placeOfBirthField);
    }

    public void setOccupationField(String occupationField) {
        this.occupationField.sendKeys(occupationField);
    }

    public void setSalaryField(String salaryField) {
        this.salaryField.sendKeys(salaryField);
    }

    public void setPartnerNameField(String partnerName) {
        this.occupationField.sendKeys(partnerName);
    }

    public void setPartnerIdField(String partnerId) {
        this.occupationField.sendKeys(partnerId);
    }

    public void setSalaryIncomeDropdown(String salaryIncomeDropdown) {
        Select dropdownOptions = new Select(this.salaryIncomeDropdown);
        dropdownOptions.selectByVisibleText(salaryIncomeDropdown);
    }

    public Step5Page clickNextButton() {
        wait.waitForElementToBeClickable(driver, nextButton, 5);
        nextButton.click();
        return new Step5Page(driver);
    }

    public void fillEmploymentDetails(String nationality, String placeOfBirth, String occupation,
                                      String salary, String partnerName,
                                      String partnerId, String salaryIncome){
        setNationalityField(nationality);
        setPlaceOfBirthField(placeOfBirth);
        setOccupationField(occupation);
        setSalaryField(salary);
        setSalaryIncomeDropdown(salaryIncome);
        setPartnerNameField(partnerName);
        setPartnerIdField(partnerId);
    }
}
