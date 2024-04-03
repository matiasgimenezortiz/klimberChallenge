package uiTests.tests;

import org.testng.annotations.Test;
import testrunner.BaseTest;
import uiTests.pages.*;

public class HireInsuranceTest extends BaseTest {

    @Test
    public void hireInsuranceTest() {
        getLogger().info("Starting test for hiring an insurance");

        HomePage homePage = new HomePage(driver);
        validate.assertTrue(homePage.isLoaded());

        homePage.fillPersonalInfo("02/06/1988", "Misiones", "362", "4682226");
        //homePage.moveSliderRandomly(); This method moves the slider randomly and the purchase can not be completed because of that
        Step2Page secondPage = homePage.clickContratarButton();
        validate.assertTrue(secondPage.isLoaded());

        secondPage.fillPhysicalInfo("168", "70");
        Step3Page thirdPage = secondPage.clickNextButton();
        validate.assertTrue(thirdPage.isLoaded());

        thirdPage.fillPersonalDetails("Matias", "Gimenez", Step3Page.generateRandomNumberID(), "Masculino", "Masculino", "Soltera/o", Step3Page.generateRandomEmail(), "superSecretPassword");
        thirdPage.fillAddressDetails("Edison", "2435", "1", "A", "3300", "Posadas");
        Step4Page step4Page = thirdPage.clickNextButton();
        validate.assertTrue(step4Page.isLoaded());

        step4Page.fillEmploymentDetails("Argentina", "Resistencia", "Test Automation Engineer", "100", "Mar", "12345679", "Sueldo");
        Step5Page fifthPage = step4Page.clickNextButton();
        validate.assertTrue(fifthPage.isLoaded());

        fifthPage.fillPaymentDetails("370000000000002");
        Step6Page sixthPage = fifthPage.clickNextButton();
        validate.assertTrue(sixthPage.isLoaded());

        SummaryPage summaryPage = sixthPage.clickNextButton();
        validate.assertTrue(summaryPage.isLoaded());

        summaryPage.acceptTermsAndConditions();
        LastPage lastPage = summaryPage.clickNextButton();
        validate.assertTrue(lastPage.isLoaded());
        validate.assertTrue(lastPage.congratsTextIsShown());
    }
}
