package test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.scrollPage;
import utils.ExtentReport.GetScreenShot;

public class scrollTest extends BaseClass {
    @Test
    public void scrollingDownTestUntilElementFound() throws Exception {
        try {
            test = extentReport.createTest("Scroll Test","Scroll Test Until Element Found");
            scrollPage scrollpage = new scrollPage(driver);
            scrollpage.scrollDownUntilFound();
            test.log(Status.INFO, "Scroll cta_button");
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
            driver.closeApp();
            driver.launchApp();
        }
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception
    {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenShotPath = GetScreenShot.capture(driver, result.getName());
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            test.log(Status.FAIL, result.getThrowable());
            test.log(Status.FAIL, "Snapshot" + test.addScreenCaptureFromPath(screenShotPath));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        driver.closeApp();
        driver.launchApp();
    }
//    @Test
//    public void scrollingHorizontalUntilElementFound() throws Exception{
//        try{
//            scrollPage scrollpage = new scrollPage(driver);
//            scrollpage.scrollDownUntilFound();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//            driver.closeApp();
//            driver.launchApp();
//        }
//    }
}
