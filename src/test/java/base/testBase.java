package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import resources.ElementUtils;
import resources.JavaScriptUtil;
import testCases.ParentRegistrationSACitizenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testBase {
    private WebDriver driver;
    private Properties prop;
    protected HomePage homePage;
    protected ParentRegistrationPage parentRegistrationPage;
    protected ElementUtils elementUtils;
    protected JavaScriptUtil javaScriptUtil;
    protected LoginPage loginPage;
    protected LearnerRegistrationPage learnerRegistrationPage;
    protected DocumentsPage documentsPage;


    @BeforeClass
    public void setUp(){

        try {
            Properties prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\config" +
                    "\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dany1\\Documents\\BoxFusionGDE\\src\\main\\java\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://schoolsadmissions-web-portal-test.azurewebsites.net/");

        homePage = new HomePage(driver);
        parentRegistrationPage = new ParentRegistrationPage(driver);
        elementUtils = new ElementUtils(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
        loginPage = new LoginPage(driver);
        learnerRegistrationPage = new LearnerRegistrationPage(driver);
        documentsPage = new DocumentsPage(driver);



        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
