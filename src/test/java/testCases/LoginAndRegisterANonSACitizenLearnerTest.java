package testCases;

import base.testBase;
import org.testng.annotations.Test;
import pages.LearnerRegistrationPage;
import pages.LoginPage;

public class LoginAndRegisterANonSACitizenLearnerTest extends testBase {


    String idOrPassport = "zz000058";
    String password = "Test@1234";
    String refugeeNum = "ref0000001";
    String name = "mother";
    String siblingName = "mom";
    String siblingGrade = "4";
    String siblingSurname = "mommy";
    String schoolSibling = "La Montagne";
    String surname = "father";
    String languageOfTeaching = "English";
    String schoolName = "L";
    String area = "Temba";

    @Test
    public void loginAndRegisterLearnerTest() throws InterruptedException {
        LoginPage loginPage = homePage.LoginButton();
        loginPage.IDorPassport(idOrPassport);
        loginPage.passwOrd(password);
        loginPage.clickSignIn();
        Thread.sleep(3000);
        LearnerRegistrationPage learnerRegistrationPage = homePage.clickRegisterAnotherLearner();
        learnerRegistrationPage.NationalityNonSouthAfricanCitizen();
        learnerRegistrationPage.DocumentStatusDocumented();
        learnerRegistrationPage.CountryOfOrigin();
        learnerRegistrationPage.refugee();
        javaScriptUtil.windowFocus();
        learnerRegistrationPage.refugeeNumber(refugeeNum);
        learnerRegistrationPage.Name(name);
        learnerRegistrationPage.Surname(surname);
        learnerRegistrationPage.GenderMale();
        javaScriptUtil.windowFocus();
        learnerRegistrationPage.clickDOB();
        learnerRegistrationPage.previousYears();
        learnerRegistrationPage.homeLanguage();
        learnerRegistrationPage.Race();
        learnerRegistrationPage.Grade1();
        learnerRegistrationPage.PreferredLanguageOfTeaching(languageOfTeaching);
        learnerRegistrationPage.isLeanerInGradeRorAnEarlyChildhoodDevelopmentProgram();
        Thread.sleep(2000);
        learnerRegistrationPage.isTheInstitutionInGauteng();
        learnerRegistrationPage.institutionName(schoolName);
        learnerRegistrationPage.suburbOrTownship(area);
        learnerRegistrationPage.applyToSchools();
        learnerRegistrationPage.siblingOrPreviousSchoolApplicationOption();
        learnerRegistrationPage.siblingName(siblingName);
        learnerRegistrationPage.siblingSurname(siblingSurname);
        learnerRegistrationPage.siblingGrade(siblingGrade);
        learnerRegistrationPage.siblingSchool(schoolSibling);
        learnerRegistrationPage.applyBtnOnLearnerApplication();
        //Assert Thank You Message
        //Assert application Message
        Thread.sleep(2000);
        learnerRegistrationPage.schoolsOfSpecializationOrFocusSchools();


    }

}
