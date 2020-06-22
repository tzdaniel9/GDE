package testCases;

import base.testBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ParentRegistrationPage;

public class ParentRegistrationSACitizenTest extends testBase {

    String idNumber = "#9001014800089";
    String dateOfBirth = "2000-01-01";


    @Test
    public void parentRegistrationOfSACitizen() throws InterruptedException {
        ParentRegistrationPage parentRegistrationPage = homePage.RegisterLink();
        parentRegistrationPage.SouthAfricanCitizen();
        parentRegistrationPage.DocumentStatusDocumented();
//        parentRegistrationPage.unDocumented();
        Thread.sleep(2000);
        parentRegistrationPage.idNumber(idNumber);
        Thread.sleep(1000);
        parentRegistrationPage.yesBtnValidationDHA();
        javaScriptUtil.sendKeysUsingJSWithCss("",dateOfBirth);
        parentRegistrationPage.dateOfBirth(dateOfBirth);



    }

}
