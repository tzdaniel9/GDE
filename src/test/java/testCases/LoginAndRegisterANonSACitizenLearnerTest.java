package testCases;

import base.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LearnerRegistrationPage;
import pages.LoginPage;
import pages.ParentRegistrationPage;

public class LoginAndRegisterANonSACitizenLearnerTest extends testBase {


    String idOrPassport = "zz000002";
    String password = "Test1234";

    @Test
    public void loginAndRegisterLearnerTest() {
        LoginPage loginPage = homePage.LoginButton();
        loginPage.IDorPassport(idOrPassport);
        loginPage.passwOrd(password);
        loginPage.clickSignIn();
//        homePage.RegisterLink();


    }

}
