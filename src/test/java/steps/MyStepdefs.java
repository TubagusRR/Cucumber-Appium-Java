package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import setups.BaseClass;

public class MyStepdefs extends BaseClass {
    @Before({"@Playstore"})
        public void base() throws Exception{
            setup();
        }


    @Given("^User Navigate to Ezeelink App$")
    public void userNavigateToEzeelinkApp() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/search_bar_hint")));
        driver.findElement(By.id("com.android.vending:id/search_bar_hint")).click();
        driver.findElementById("com.android.vending:id/search_bar_text_input").sendKeys("Ezeelink");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @After({"@Playstore"})
    public void stop(){ TearDown(); }
}
