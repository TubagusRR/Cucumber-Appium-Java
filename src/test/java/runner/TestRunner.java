package runner;

import com.aventstack.extentreports.ExtentReports;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        , monochrome = false
        , plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html" }
        , glue = { "steps" }
        , strict = true
//        , tags = {"@RT-interact"}
)
public class TestRunner {

    public Scenario scenario;
    public static ExtentReports extent;
    @Before
    public void before(Scenario scenario){
        this.scenario = scenario;
    }

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

//        Reporter.setSystemInfo("UserName", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Application Name", "Practice Test App ");
//        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//        Reporter.setSystemInfo("Environment", "Production");
//        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");


    }

    @After
    public void tearDown(WebDriver driver, Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.write("Step finished");
            scenario.embed(screenshot, "image/png");
        }
    }
}
