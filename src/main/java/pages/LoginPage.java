package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    String IDOrPassport = "zz000002";
    String password = "Test@1234";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By IdOrPassport = By.cssSelector(".ant-btn.gde-navbar-menu-action");
    By Password = By.name("userNameOrEmailAddress");
    By signIn = By.xpath("//button[@text='Sign In']");


//    public HomePage clickSignIn(String IDOrPassport,String password){
//        IDorPassport("zz000002");
//        passwOrd("Test@1234");
//        clickSignIn();
//        return new HomePage(driver);
//    }

    public  void IDorPassport(String iDorPassport){
        driver.findElement(IdOrPassport).sendKeys(iDorPassport);

    }

    public void passwOrd(String password){
        driver.findElement(Password).sendKeys(password);
    }

    public HomePage clickSignIn(){
        driver.findElement(signIn).click();
        return new HomePage(driver);
    }

}
