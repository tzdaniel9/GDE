package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    String IDOrPassport = "zz000002";
    String password = "Test@1234";
    private By  IdOrPassport = By.cssSelector("[name='userNameOrEmailAddress']");
    private By Password = By.cssSelector("[name='password']");
    private By signIn = By.cssSelector("[text='Sign In']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


//    public HomePage clickSignIn(String IDOrPassport,String password){
//        IDorPassport("zz000002");
//        passwOrd("Test@1234");
//        clickSignIn();
//        return new HomePage(driver);
//    }

    public void IDorPassport(String iDorPassport) {
        driver.findElement(IdOrPassport).sendKeys(iDorPassport);

    }

    public void passwOrd(String password) {
        driver.findElement(Password).sendKeys(password);
    }

    public HomePage clickSignIn() {
        driver.findElement(signIn).click();
        return new HomePage(driver);
    }

}
