package testCases;

import base.testBase;
import org.testng.annotations.Test;
import pages.ParentRegistrationPage;

public class AsylumSeekerTest extends testBase {
    String name = "Mary";
    String surname = "Jane";
    String mobileNumber = "0650000001";
    String password = "Test@1234";
    String confirmPassword = "Test@1234";
    String otpPin = "000000";
    String homeAddress = "265 West Ave";
    String asylumSeekerNumber = "2010mn02";
    String workAddress = "265 West Ave";


    ParentRegistrationPage parentRegistrationPage;

    @Test
    public void asylumSeekerApplication() throws InterruptedException {
        ParentRegistrationPage parentRegistrationPage = homePage.RegisterLink();
        parentRegistrationPage.NationalityNonSouthAfricanCitizen();
        parentRegistrationPage.DocumentStatusDocumented();
        parentRegistrationPage.CountryOfOrigin();
        parentRegistrationPage.asylumSeekerImmigrationStatus();
        parentRegistrationPage.asylumSeekerNumber(asylumSeekerNumber);
        parentRegistrationPage.Name(name);
        parentRegistrationPage.Surname(surname);
        parentRegistrationPage.GenderFemale();
        parentRegistrationPage.CellphoneNumber(mobileNumber);
        parentRegistrationPage.password(password);
        parentRegistrationPage.ConfirmPassword(confirmPassword);
        parentRegistrationPage.NextStepButton();
        Thread.sleep(2000);
        parentRegistrationPage.insertYourOTP(otpPin);
        parentRegistrationPage.okButtonOTP();
        javaScriptUtil.windowFocus();
        parentRegistrationPage.AcceptTermsAndConditionsCheckBox();
        javaScriptUtil.windowFocus();
        parentRegistrationPage.ButtonOK();
        Thread.sleep(3000);
        parentRegistrationPage.searchForHomeAddress(homeAddress);
        Thread.sleep(2500);
        parentRegistrationPage.submitAddress();
        Thread.sleep(3000);
        parentRegistrationPage.intentToApplyCloseToWork();
        Thread.sleep(5000);
        javaScriptUtil.windowFocus();
        parentRegistrationPage.searchForWorkAddress(workAddress);
        Thread.sleep(2000);
        parentRegistrationPage.submitAddress();
        Thread.sleep(3000);

    }

}
