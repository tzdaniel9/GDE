package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;
import org.testng.xml.XmlSuite;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

public class ExtentManager implements IReporter {
    private  static ExtentReports extent;

    public static ExtentReports createInstance(){
        String fileName = getReportName();
        String directory = System.getProperty("user.dir")+"/reports/";
        new File(directory).mkdirs();
        String path = directory + fileName;
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);

//        htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("AutomationTestResults");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.setSystemInfo("BoxFusion","GDE");
        extent.setSystemInfo("Browser","Firefox");
        extent.attachReporter(htmlReporter);
        return extent;
    }

    public static String getReportName(){
        Date d = new Date();
        String fileName = "Automation Report"+ "_" + d.toString().replace(":","_").replace(" ","_")+ ".html";
        return fileName;
    }

}
