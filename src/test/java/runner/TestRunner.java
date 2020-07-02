package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import test.ExtentReportDemo;
import utils.ExtentReport.GetScreenShot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        , monochrome = false
        , plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html",
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
        }
        , glue = { "steps" }
        , strict = true
//        , tags = {"@RT-interact"}
)
public class TestRunner extends ExtentReportDemo {

    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    @AfterClass
    public static void setup() {
        extent = new ExtentReports();
        Reporter.loadXMLConfig(new File("extent-config.xml"));
//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
        extent.setSystemInfo("UserName", System.getProperty("user.name"));
        extent.setSystemInfo("Application Name", "Practice Test App ");
        extent.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        extent.setSystemInfo("Environment", "Production");
        extent.setTestRunnerOutput("Test Execution Cucumber Report");

        htmlReporter.config().setDocumentTitle("Automation Test Cucumber");

//        Reporter.setSystemInfo("UserName", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Application Name", "Practice Test App ");
//        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//        Reporter.setSystemInfo("Environment", "Production");
//        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");


    }

//    public static void screenshot(WebDriver driver, long ms)
//    {
//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(source, new File("./ScreenShots/"+ms+"Facebook.png"));
//            System.out.println("ScreenShot Taken");
//        }
//        catch (Exception e)
//        {
//            System.out.println("Exception while taking ScreenShot "+e.getMessage());
//        }
//    }
}



