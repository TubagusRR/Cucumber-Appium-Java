package test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.chipViewPage;
import utils.ExtentReport.BaseTest.*;
import utils.ExtentReport.GetScreenShot;

import java.io.IOException;

public class chipViewTest extends BaseClass {
    @Test
    public void clickChipView(){

        try {
            test = extentReport.createTest("asdf","asdf");
            test.log(Status.INFO, "Test Started");
            chipViewPage chipviewPage = new chipViewPage(driver);
            test.log(Status.PASS ,"Open PlayStore");
            chipviewPage.multipleClass(driver);
            test.log(Status.PASS, "Click Game");
            chipviewPage.verifyActionBar(driver);
            test.log(Status.PASS, "Verify Tittle");
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
            driver.closeApp();
            driver.launchApp();
        }
    }
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
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
}
