package testCases;

import base.testBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DocumentsPage;
import pages.LearnerRegistrationPage;
import pages.ParentRegistrationPage;

import java.awt.*;

public class NonSADocumentedParentRegistrationTest extends testBase {

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
    public void parentRegistrationProcessNonSa() throws InterruptedException, AWTException {
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
//        parentRegistrationPage.insertYourOTP(OTPNumber);
//        parentRegistrationPage.okButtonOTP();
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
        Thread.sleep(7000);
        LearnerRegistrationPage learnerRegistrationPage = parentRegistrationPage.submitWorkAddress();
        Thread.sleep(4000);
        learnerRegistrationPage.NationalityNonSouthAfricanCitizen();
        learnerRegistrationPage.DocumentStatusDocumented();
        learnerRegistrationPage.CountryOfOrigin();
        learnerRegistrationPage.inTheCountryForStudy();
        learnerRegistrationPage.PassportNumber(passportNumberLearner);
        learnerRegistrationPage.Name(nameLearner);
        learnerRegistrationPage.Surname(surnameLearner);
        learnerRegistrationPage.GenderMale();
        javaScriptUtil.windowFocus();
//        learnerRegistrationPage.clickDOB();
        learnerRegistrationPage.clickDOB();
        learnerRegistrationPage.previousYears();
        learnerRegistrationPage.homeLanguage();
        learnerRegistrationPage.Race();
        learnerRegistrationPage.Grade8();
        javaScriptUtil.windowFocus();
        learnerRegistrationPage.PreferredLanguageOfTeaching(LanguageOfTeaching);
        learnerRegistrationPage.isTheInstitutionInGauteng();
        learnerRegistrationPage.schoolIsPrivate();
        learnerRegistrationPage.applyToSchools();
        Thread.sleep(3000);
        learnerRegistrationPage.applicationOptionFeederZone();
        javaScriptUtil.windowFocus();
        learnerRegistrationPage.institutionName(schoolName);
        learnerRegistrationPage.schoolSearchResults();
        learnerRegistrationPage.SubmitApplications();
        Thread.sleep(4000);
        javaScriptUtil.windowFocus();
        DocumentsPage documentsPage = learnerRegistrationPage.continueToDocuments();

        documentsPage.documntsToBeUploaded(DocumentsPage.IDOrPassport, DocumentsPage.idOrPassportPath);
        Thread.sleep(10000);
        documentsPage.documntsToBeUploaded(DocumentsPage.BirthCertificate, DocumentsPage.BirthCertificatePath);
        Thread.sleep(10000);

        documentsPage.documntsToBeUploaded(DocumentsPage.ProofOfAddress, DocumentsPage.ProofOfAddressPath);
        Thread.sleep(10000);

        documentsPage.documntsToBeUploaded(DocumentsPage.LatestReport, DocumentsPage.LatestReportPath);
        Thread.sleep(10000);

        documentsPage.goBackToDashBoard();

    }
}
