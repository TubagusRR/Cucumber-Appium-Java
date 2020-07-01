package steps;

import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseClass;
import pages.DownloadAppPage;
import pages.scrollPage;
import runner.TestRunner;

public class ScrollStep extends BaseClass {
    DownloadAppPage dp = new DownloadAppPage(driver);
    scrollPage sp = new scrollPage(driver);

    @Given("^Playstore Opened$")
    public void playstoreOpened() throws Exception {
        ExtentTest loginfo=null;
        try{
            sp.waitApp(driver);
        }catch(Exception e){
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Then("^User Scrolling Down Until Element Found$")
    public void userScrollingDown() throws Exception {
        sp.scrollDownUntilFound();
    }

    @After({"@Playstore"})
    public void stop(){
        TearDown();
    }
}
