package testCases;

import base.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LearnerRegistrationPage;
import pages.LoginPage;

public class saCitizenLearnerTest extends testBase {

    String TrueId = "0506135225080";
    String FakeId = "9203044800085";
    String idOrPassword= "zz000049";
    String password = "Test@1234";
    String refugeeNum = "ref0000001";
    String name = "mary";
    String siblingName = "mom";
    String siblingGrade = "4";
    String siblingSurname = "mommy";
    String schoolSibling = "La Montagne";
    String surname = "father";
    String languageOfTeaching = "English";
    String schoolName = "L";
    String area = "Temba";


    @Test
    public void registerSABornLearner() throws InterruptedException {
        LoginPage loginPage = homePage.LoginButton();
        loginPage.IDorPassport(idOrPassword);
        loginPage.passwOrd(password);
        loginPage.clickSignIn();

        LearnerRegistrationPage learnerRegistrationPage = homePage.clickRegisterAnotherLearner();
        learnerRegistrationPage.SouthAfricanCitizen();
        learnerRegistrationPage.DocumentStatusDocumented();
        learnerRegistrationPage.idNumber(FakeId);
        learnerRegistrationPage.yesBtnValidationDHA();
        learnerRegistrationPage.Name(name);
        learnerRegistrationPage.Surname(surname);
        learnerRegistrationPage.clickDOB();
        learnerRegistrationPage.previousYears();
        learnerRegistrationPage.homeLanguage();
        learnerRegistrationPage.Grade8();
        learnerRegistrationPage.PreferredLanguageOfTeaching(languageOfTeaching);
        learnerRegistrationPage.isTheInstitutionInGauteng();
        learnerRegistrationPage.schoolIsPrivate();







    }
}
