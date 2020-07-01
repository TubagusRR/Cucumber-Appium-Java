package test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportDemo {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReport;
    public static ExtentTest test;

    @BeforeSuite
    public void ExtentSetup() {
        String dateName = new SimpleDateFormat("ddMMyyyy").format(new Date());
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\reporting.html");

        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        extentReport.setAnalysisStrategy(AnalysisStrategy.CLASS);

        String css = ".r-img{width : 30%;}";

        htmlReporter.config().setCSS(css);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Demo Report");
        htmlReporter.config().setReportName("Report Success");
//        htmlReporter.config().setAutoCreateRelativePathMedia(true);

        extentReport.setSystemInfo("OS", "Windows");
        extentReport.setSystemInfo("Host Name", "Tubagus R");
        extentReport.setSystemInfo("Environment", "QA");
        extentReport.setSystemInfo("User Name", "Tubagus Radhiyya R");

    }

//    @AfterMethod
//    public void getResult(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String screenShotPath = GetScreenShot.capture(driver, "test");
//            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
//            test.log(Status.FAIL, result.getThrowable());
//            test.log(Status.FAIL, "Snapshot" + test.addScreenCaptureFromPath(screenShotPath));
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
//        } else {
//            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
//            test.skip(result.getThrowable());
//        }
//
//    }

    @AfterSuite
    public void ExtentTearDown() {
        extentReport.flush();
    }
}
