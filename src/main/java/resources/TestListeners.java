package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;


public class TestListeners implements ITestListener {
 /*   private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private WebDriver driver;

    public void onStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getTestClass().getName() + "::" +
                result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Successful<b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.PASS, m);
    }

    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        extentTest.get().fail("<details><summary>,<b>font color=red>" +
                "Exception Occured, click to see details:" + "</font></b></summary>" +
                exceptionMessage.replaceAll(",", "<b>") + "</details> \n");

        WebDriver driver = ((TestClassUsingListeners)result.getInstance()).driver;
        String path = takeScreenshot(driver, result.getMethod().getMethodName());
        try {
            extentTest.get().fail("<details>"<b>font color=red>" + "Screenshot of failure" + "</font><b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            "Exception Occured, click to see details:" + "</font></b></summary>" +
                    exceptionMessage.replaceAll(",", "<b>") + "</details> \n";

        } catch (IOException e) {
            extentTest.get().fail("Test failed cannot attach screenshot");
        }
        String logText = "<b>TestMethod" + methodName +"Failed</b>";
        Markup m = MarkupHelper.createLabel(logText,ExtentColor.RED);
        extentTest.get().log(Status.SKIP, m);

    }

    public void onTestSkipped(ITestResult result) {
        String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Skipped<b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP, m);
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null){
            extent.flush();
        }
    }

    public String takeScreenshot(WebDriver driver, String methodName){
        String filName = getScreenShotName(methodName);
        String directory = System.getProperty("user.dir")+"/screenshots/";
        new File(directory).mkdirs();
        String path = directory + filName;

        try {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(path));
            System.out.println("***************************");
            System.out.println("screenshot stored at: " + path);
            System.out.println("***************************");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
*/

}
