package testCases;

import base.testBase;
import org.testng.annotations.Test;
import pages.DocumentsPage;
import pages.LearnerRegistrationPage;
import pages.ParentRegistrationPage;

public class OTPTest extends testBase {

    LearnerRegistrationPage learnerRegistrationPage;
    DocumentsPage documentsPage;
    String phoneNumber = "0700000064";
    String password = "Test@1234";
    String confirmPassword = "Test@1234";
    String emailAddress = "box@fusion.co.za";
    String passportNumberParent = "zz000064";
    String name = "box";
    String surname = "fusion";
    String OTPNumber = "000000";
    String homeAddress = "32 Nora Avenue";
    String workAddress = "265 West Ave";
    String passportNumberLearner = "zz100001";
    String nameLearner = "boxed";
    String surnameLearner = "fusion";
    String dateOfBirth = "2008-01-01";
    String LanguageOfTeaching = "English";
    String schoolName = "La";

    @Test
    public void OneTimePinTestWorkingOrNote() throws InterruptedException {
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
    }

}
