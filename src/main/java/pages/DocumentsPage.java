package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;

import static resources.ElementUtils.UploadFileRobot.uploadFile;

public class DocumentsPage {

    public static String idOrPassportPath = "\\src\\main\\java\\documents\\tester.jpg";
    public static String ProofOfAddressPath = "\\src\\main\\java\\documents\\tester.jpg";
    public static String BirthCertificatePath = "\\src\\main\\java\\documents\\tester.jpg";
    public static String LatestReportPath = "\\src\\main\\java\\documents\\tester.jpg";

    public static By IDOrPassport = By.className("gde-parent-docs-upload-button-idOrPassport");
    public static By ProofOfAddress = By.className("gde-parent-docs-upload-button-homeAdress");
    public static By BirthCertificate = By.className("gde-child-docs-upload-button-birthCert");
    public static By LatestReport = By.className("gde-child-docs-upload-button-report gde");
    public static By GoBackToDashBoard = By.xpath("//button[@text='Go Back To Dashboard']");
    WebDriver driver;
//    By ProofOfAddress = By.cssSelector("gde-parent-docs-upload-button-homeAdress");


    public DocumentsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void documntsToBeUploaded(By doc, String path) throws InterruptedException, AWTException {
        driver.findElement(doc).click();
        this.RobotUpload(path);
    }

    public void RobotUpload(String path) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(630, 420);
        robot.delay(1500);


        uploadFile(path);
        Thread.sleep(2000);
    }

    public void ProofOfAddress() throws InterruptedException, AWTException {
        driver.findElement(ProofOfAddress).click();
    }

    public void BirthCertificate() throws InterruptedException, AWTException {
        driver.findElement(BirthCertificate).click();
    }

    public void LatestReport() throws InterruptedException, AWTException {
        driver.findElement(LatestReport).click();
    }

    public void goBackToDashBoard() {
        driver.findElement(GoBackToDashBoard).click();
    }
}
