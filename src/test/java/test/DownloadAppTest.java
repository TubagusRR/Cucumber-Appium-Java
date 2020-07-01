package test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DownloadAppPage;
import utils.ExtentReport.GetScreenShot;

public class DownloadAppTest extends BaseClass {
    @Test
    public void UpdateAppPositive(){
        try{
            DownloadAppPage downloadAppPage = new DownloadAppPage(driver);
            test = extentReport.createTest("test","test");
            test.log(Status.INFO, "Test Started");
            downloadAppPage.clickSearchBar(driver);
            downloadAppPage.enterKeyword("Ezeelink");
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            downloadAppPage.clickApp(driver);
//            downloadAppPage.clickUpdateButton(driver);
            test.log(Status.PASS, "Test");
       }catch(Exception e){
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
 }


