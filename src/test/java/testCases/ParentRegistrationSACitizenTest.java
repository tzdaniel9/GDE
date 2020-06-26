package testCases;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ParentRegistrationPage;

public class ParentRegistrationSACitizenTest extends testBase {
    ParentRegistrationPage parentRegistrationPage;
    String idNumber = "#9001014800089";
    String dateOfBirth = "2000-01-01";
    String Name = "Louw";

    String phoneNumber = "0700000042";
    String password = "Test@1234";
    String confirmPassword = "Test@1234";
    String emailAddress = "box@fusion.co.za";
    String passportNumberParent = "zz000042";
    String name = "box";
    String surname = "fusion";
    String OTPNumber = "000000";
    String homeAddress = "SupermanFarm";
    String workAddress = "Mogalies Mountain Lodge & Spa";
    String passportNumberLearner = "zz100001";
    String nameLearner = "boxed";
    String surnameLearner = "fusion";
    String LanguageOfTeaching = "English";
    String houseNumber = "26";
    String Title = "Your address has been selected!";
    String streetName = "Pretoria Road";
    String area = "Pretoria Road";
    String mapAddress = "Phianna AH";
    String nearestTownOrVillage = "Elata Kennels";


    @Test
    public void parentRegistrationOfSACitizen() throws InterruptedException {
        ParentRegistrationPage parentRegistrationPage = homePage.RegisterLink();
        parentRegistrationPage.SouthAfricanCitizen();
        parentRegistrationPage.DocumentStatusDocumented();
//        parentRegistrationPage.unDocumented();
        Thread.sleep(1500);
        parentRegistrationPage.idNumber(idNumber);
        Thread.sleep(3000);
        parentRegistrationPage.yesBtnValidationDHA();
        Thread.sleep(1000);
        javaScriptUtil.windowFocus();
        parentRegistrationPage.clickDOBParent();
        parentRegistrationPage.previousYears();
        parentRegistrationPage.Name(Name);
        parentRegistrationPage.Surname(surname);
        parentRegistrationPage.GenderFemale();
        javaScriptUtil.windowFocus();
        parentRegistrationPage.CellphoneNumber(phoneNumber);
        parentRegistrationPage.password(password);
        parentRegistrationPage.ConfirmPassword(confirmPassword);
        parentRegistrationPage.NextStepButton();
        Thread.sleep(1000);
        parentRegistrationPage.insertYourOTP(OTPNumber);
//        Thread.sleep(500);
//        parentRegistrationPage.okButtonOTP();
        javaScriptUtil.windowFocus();
        parentRegistrationPage.AcceptTermsAndConditionsCheckBox();
        javaScriptUtil.windowFocus();
        parentRegistrationPage.ButtonOK();
        Thread.sleep(3000);
        parentRegistrationPage.searchForHomeAddress(homeAddress);
        Thread.sleep(2500);
        parentRegistrationPage.clickCantFindHomeAddress();
        parentRegistrationPage.suburbOrTownship();
        parentRegistrationPage.freeStandingHouse();
        parentRegistrationPage.houseNumber(houseNumber);
        parentRegistrationPage.streetName(streetName);
        parentRegistrationPage.areaOrSuburbOrTownShipOrExtension(area);
        Thread.sleep(1000);
        parentRegistrationPage.clickSelectYourAddressFromMap();
        javaScriptUtil.windowFocus();
        parentRegistrationPage.enterYourAddressOnMap(mapAddress);
        Thread.sleep(1500);
//        Assert.assertTrue();
        parentRegistrationPage.confirmMap();
        parentRegistrationPage.submitAddress();
        Thread.sleep(3000);
        parentRegistrationPage.intentToApplyCloseToWork();
        parentRegistrationPage.searchForWorkAddress(workAddress);
        Thread.sleep(2000);
        parentRegistrationPage.cantFindWorkAddress();
        parentRegistrationPage.intentToApplyCloseToWork();
        parentRegistrationPage.plotFarmRuralArea();
        parentRegistrationPage.doesYourLocationHaveAFormAddress();
        parentRegistrationPage.nameOfTheNearestTownOrVillage(nearestTownOrVillage);
        Thread.sleep(1000);
        parentRegistrationPage.clickSelectYourAddressFromMap();
        parentRegistrationPage.enterYourAddressOnMap(workAddress);
        parentRegistrationPage.confirmMap();
        parentRegistrationPage.submitWorkAddress();














    }

}
