package testCases;

import base.testBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ParentRegistrationPage;

public class ParentRegistrationWithValidSAIDTest extends testBase {
    ParentRegistrationPage parentRegistrationPage;
    String ID = "#6910050112089";
    String phoneNumber = "0700000035";
    String password = "Test@1234";
    String confirmPassword = "Test@1234";
    String emailAddress = "box@fusion.co.za";
    String passportNumberParent = "zz000035";
    String name = "Felicity";
    String surname = "Louw";
    String OTPNumber = "000000";
    String homeAddress = "Mandela Square Kliptown";
    String StatusOfArea = "Occupant";
    String workAddress = "265 West Ave";
    String statusOfOccupant ="Owner";
    String passportNumberLearner = "zz100001";
    String nameLearner = "boxed";
    String surnameLearner = "fusion";
    String dateOfBirth = "2008-01-01";
    String LanguageOfTeaching = "English";


    @Test
    public void saCitizenWithValidID() throws InterruptedException {
        ParentRegistrationPage parentRegistrationPage = homePage.RegisterLink();
        parentRegistrationPage.SouthAfricanCitizen();
        parentRegistrationPage.DocumentStatusDocumented();
        parentRegistrationPage.idNumber(ID);
        Thread.sleep(2000);
        parentRegistrationPage.cancelButtonOnValidSaId();//ToDo
    }


}
