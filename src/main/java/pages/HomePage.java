package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends LearnerRegistrationPage {

    By Home = By.cssSelector(".gde-navbar-menu-link:nth-child(2)");
    By AboutUs = By.cssSelector("li.gde-navbar-menu-link:nth-child(4)");
    By ContactUs = By.cssSelector("li.gde-navbar-menu-link:nth-child(6)");
    By FAQs = By.cssSelector("li.gde-navbar-menu-link:nth-child(8)");
    By Register = By.cssSelector("li.gde-navbar-menu-link:nth-child(10)");
    By login = By.cssSelector(".ant-btn.gde-navbar-menu-action");
    By LogOut = By.cssSelector("button.ant-btn");
    By RegisterAnotherLearner = By.xpath("//button[@text='Register Another Learner']");
    private WebDriver driver;
    //    By GDELogo = By

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }


    public AboutUs clickAboutUs(WebDriver driver) {
        driver.findElement(AboutUs).click();
        return new AboutUs(driver);
    }

    public void ContactUs() {
        driver.findElement(ContactUs);
    }

    public void FAQs() {
        driver.findElement(FAQs);
    }

    public LoginPage LoginButton() {
        driver.findElement(login).click();
        return new LoginPage(driver);
    }

    public void LogoutButton() {
        driver.findElement(LogOut);
    }

    public ParentRegistrationPage RegisterLink(){
        driver.findElement(Register).click();
        return new ParentRegistrationPage(driver);
    }

    public LearnerRegistrationPage clickRegisterAnotherLearner(){
        driver.findElement(RegisterAnotherLearner).click();
        return new LearnerRegistrationPage(driver);
    }

}
