package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUs {

    private WebDriver driver;
    By SearchBox = By.cssSelector("input.ant-input:nth-child(1)");

    public AboutUs(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchForSchoolsWithFeederZonesThatCoverMyAddress(){

    }
}
