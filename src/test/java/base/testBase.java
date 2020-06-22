package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LearnerRegistrationPage;
import pages.LoginPage;
import pages.ParentRegistrationPage;
import resources.ElementUtils;
import resources.JavaScriptUtil;
import testCases.ParentRegistrationSACitizenTest;

public class testBase {
    private WebDriver driver;
    protected HomePage homePage;
    protected ParentRegistrationPage parentRegistrationPage;
    protected ElementUtils elementUtils;
    protected JavaScriptUtil javaScriptUtil;
    protected LoginPage loginPage;
    protected LearnerRegistrationPage learnerRegistrationPage;

    @BeforeClass
    public void setUp(){


        System.setProperty("webdriver.gecko.driver", "\\C:\\Users\\dany1\\Documents\\applitools-\\MockGDE\\src\\main\\java\\QA\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://schoolsadmissions-web-portal-perf2.azurewebsites.net/");

        homePage = new HomePage(driver);
        parentRegistrationPage = new ParentRegistrationPage(driver);
        elementUtils = new ElementUtils(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        loginPage = new LoginPage(driver);
        learnerRegistrationPage = new LearnerRegistrationPage(driver);


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
