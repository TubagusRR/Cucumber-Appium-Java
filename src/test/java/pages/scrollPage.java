package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class scrollPage {
    private AndroidDriver driver;

    public scrollPage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    By app = By.id("com.android.vending:id/cta_button");
    @AndroidFindBy(id = "com.android.vending:id/li_thumbnail")
    private MobileElement home;

    public void scrollDownUntilFound() throws Exception {
        Boolean isElementfound = driver.findElements(app).size() > 0;
            while (isElementfound == false){
                swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,2000);
                isElementfound = driver.findElements(app).size() > 0;
            }
    }

    public void waitApp(AndroidDriver<MobileElement> driver) throws Exception{
        waitUntilELementFound(driver, 20, home);
    }

//    public void swipeHorizontalUntilTheElementFound() throws Exception{
//        Boolean isElementFound = driver.findElements(app).size() > 0;
//        while (isElementFound == false) {
//            swipeHorizontal((AppiumDriver) driver, 0,0,0,0);
//            isElementFound = driver.findElements(app).size() > 0;
//        }
//    }

    public static void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration)throws Exception{
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver).press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release()
                .perform();
    }

    public static void swipeHorizontal(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception{
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver).press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release()
                .perform();
    }

    public void waitUntilELementFound(AppiumDriver driver, int secWait, MobileElement elementID){
        WebDriverWait wait = new WebDriverWait(driver, secWait);
        wait.until(ExpectedConditions.visibilityOf(elementID));
    }
}
