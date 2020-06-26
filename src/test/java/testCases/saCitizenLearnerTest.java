package testCases;

import base.testBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LearnerRegistrationPage;
import pages.LoginPage;

public class saCitizenLearnerTest extends testBase {

    String TrueId = "0506135225080";
    String FakeId = "9203044800085";
    String idOrPassword= "zz000062";
    String password = "Test@1234";
    String refugeeNum = "ref0000001";
    String name = "mary";
    String siblingName = "mom";
    String siblingGrade = "4";
    String siblingSurname = "mommy";
    String schoolSibling = "La Montagne";
    String surname = "father";
    String languageOfTeaching = "English";
    String schoolName = "Pret";
    String area = "Temba";
    String schoolCurrent = "Pretoria Boys";
    String title;

    WebDriver driver;


    @Test
    public void registerSABornLearner() throws InterruptedException {
        LoginPage loginPage = homePage.LoginButton();
        loginPage.IDorPassport(idOrPassword);
        loginPage.passwOrd(password);
        loginPage.clickSignIn();
        title = driver.getTitle();
        Assert.assertEquals(title,"","title does not match"); //ToDo
        Thread.sleep(2000);
        LearnerRegistrationPage learnerRegistrationPage = homePage.clickRegisterAnotherLearner();
        learnerRegistrationPage.SouthAfricanCitizen();
        learnerRegistrationPage.DocumentStatusDocumented();
        learnerRegistrationPage.idNumber(FakeId);
        learnerRegistrationPage.yesBtnValidationDHA();
        learnerRegistrationPage.Name(name);
        learnerRegistrationPage.Surname(surname);
        learnerRegistrationPage.GenderFemale();
        learnerRegistrationPage.clickDOB();
        learnerRegistrationPage.previousYears();
        learnerRegistrationPage.homeLanguage();
        learnerRegistrationPage.Grade8();
        learnerRegistrationPage.PreferredLanguageOfTeaching(languageOfTeaching);
        learnerRegistrationPage.isTheInstitutionInGauteng();
        learnerRegistrationPage.schoolIsPublic();
        learnerRegistrationPage.currentSchool(schoolCurrent);
        learnerRegistrationPage.applyToSchools();
        title = driver.getTitle();
        Assert.assertEquals(title,"GDE | Complete form","title does not match"); //ToDo

        learnerRegistrationPage.schoolsOfSpecializationOrFocusSchools();
        learnerRegistrationPage.institutionName(schoolName);
        learnerRegistrationPage.schoolSearchResults();
        boolean checked = learnerRegistrationPage.youCanOnlyApplyTo1SchoolsAtATimeForThisApplicationOption();
        Assert.assertTrue(checked);
        Assert.assertEquals(checked,true);









    }
}
