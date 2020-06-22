package testCases;

import base.testBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LearnerRegistrationPage;
import pages.ParentRegistrationPage;

public class NonSADocumentedParentRegistrationTest extends testBase {

    LearnerRegistrationPage learnerRegistrationPage;
    String phoneNumber = "0700000008";
    String password = "Test@1234";
    String confirmPassword = "Test@1234";
    String emailAddress = "box@fusion.co.za";
    String passportNumberParent = "zz000008";
    String name = "box";
    String surname = "fusion";
    String OTPNumber = "000000";
    String homeAddress = "32 Nora Avenue";
    String workAddress = "265 West Ave";
    String passportNumberLearner = "zz100000";
    String nameLearner = "boxed";
    String surnameLearner = "fusion";
    String dateOfBirth = "2008-01-01";


    @Test
    public void parentRegistrationProcessNonSa() throws InterruptedException {
        ParentRegistrationPage parentRegistrationPage = homePage.RegisterLink();
        parentRegistrationPage.NationalityNonSouthAfricanCitizen();
        parentRegistrationPage.DocumentStatusDocumented();
        parentRegistrationPage.CountryOfOrigin();  //ToDo
        parentRegistrationPage.ImmigrationStatus();
        parentRegistrationPage.PassportNumber(passportNumberParent);
        parentRegistrationPage.Name(name);
        parentRegistrationPage.Surname(surname);
        parentRegistrationPage.GenderMale();
        parentRegistrationPage.CellphoneNumber(phoneNumber);
        parentRegistrationPage.emailAddress();
        parentRegistrationPage.password(password);
        parentRegistrationPage.ConfirmPassword(confirmPassword);
        parentRegistrationPage.nextButton();
        Thread.sleep(2000);
        parentRegistrationPage.insertYourOTP(OTPNumber);
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
        parentRegistrationPage.NonIntentToApplyCloseToWork();
        Thread.sleep(5000);
        LearnerRegistrationPage learnerRegistrationPage = parentRegistrationPage.submitWorkAddress();
        Thread.sleep(2000);
        parentRegistrationPage.NationalityNonSouthAfricanCitizen();
        parentRegistrationPage.DocumentStatusDocumented();
        learnerRegistrationPage.CountryOfOrigin();
        learnerRegistrationPage.ImmigrationStatus();
        learnerRegistrationPage.PassportNumber(passportNumberLearner);
        learnerRegistrationPage.Name(nameLearner);
        learnerRegistrationPage.Surname(surnameLearner);
        learnerRegistrationPage.GenderMale();
        learnerRegistrationPage.clickDOB();
        learnerRegistrationPage.dateOfBirth(dateOfBirth);
//        learnerRegistrationPage


    }
}
