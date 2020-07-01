package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseClass;

public class MyStepdefs extends BaseClass {
    @Before({"@Playstore"})
        public void base() throws Exception{
            setup();
        }

    @Then("^User Navigate to Ezeelink App$")
    public void userNavigateToEzeelinkApp() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/bucket_items")));
        driver.findElementById("com.android.vending:id/bucket_items").click();
    }

    @When("^User Fill the Search Bar with Ezeelink$")
    public void userFillTheSearchBarWithEzeelink() {
        driver.findElementById("com.android.vending:id/search_bar_text_input").sendKeys("Ezeelink");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Given("^Playstore Opened User Click Search Bar$")
    public void playstoreOpenedUserClickSearchBar() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/search_bar_hint")));
        driver.findElement(By.id("com.android.vending:id/search_bar_hint")).click();
    }

    @After({"@Playstore"})
    public void stop(){ TearDown(); }
}
