package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DownloadAppPage {
    private AndroidDriver<MobileElement> driver;

    public DownloadAppPage(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.android.vending:id/search_bar_hint")
    private MobileElement searchBar;

    @AndroidFindBy(id = "com.android.vending:id/search_bar_text_input")
    private MobileElement inputTittle;

    @AndroidFindBy(id = "com.android.vending:id/bucket_items")
    private MobileElement listViewApp;

    @AndroidFindBy(id = "com.android.vending:id/right_button")
    private MobileElement updateButton;

    @AndroidFindBy(id = "com.android.vending:id/bucket_items")
    private MobileElement bucketItems;

//    @AndroidFindBy(id = "com.android.vending:id/search_box_idle_text")
//    private MobileElement searchBar;
//
//    @AndroidFindBy(id = "com.android.vending:id/search_box_text_input")
//    private MobileElement inputTittle;
//
//    @AndroidFindBy(id = "com.android.vending:id/li_thumbnail")
//    private MobileElement listViewApp;
//
//    @AndroidFindBy(id = "com.android.vending:id/buy_button")
//    private MobileElement updateButton;





    public void clickSearchBar(AndroidDriver<MobileElement> driver){
        waitUntilELementFound(driver, 20, searchBar);
        searchBar.click();
    }

    public void enterKeyword(String tittle){
        inputTittle.sendKeys(tittle);
    }

    public void clickApp(AndroidDriver<MobileElement> driver){
        waitUntilELementFound(driver, 20, bucketItems);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<MobileElement> appList = driver.findElements(By.id("com.android.vending:id/bucket_items"));
        try {
            if(wait.until(ExpectedConditions.visibilityOf((MobileElement) listViewApp)) != null) {
                appList.get(1).click();
                Thread.sleep(10000);
            }else{
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickUpdateButton(AndroidDriver<MobileElement> driver){
        waitUntilELementFound(driver, 20, updateButton);
        updateButton.click();
    }

    public void waitUntilELementFound(AppiumDriver driver, int secWait, MobileElement elementID){
        WebDriverWait wait = new WebDriverWait(driver, secWait);
        wait.until(ExpectedConditions.visibilityOf(elementID));
    }

//    public void clickSearchBar(AndroidDriver<MobileElement> driver){
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/search_box_idle_text")));
//        searchBar.click();
//    }
//
//    public void enterKeyword(String tittle){
//        inputTittle.sendKeys(tittle);
//    }
//
//    public void clickApp(AndroidDriver<MobileElement> driver){
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/li_thumbnail")));
//        listViewApp.click();
//    }
//
//    public void clickUpdateButton(AndroidDriver<MobileElement> driver){
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/buy_button")));
//        updateButton.click();
//    }
//
//    public void verifyTittle(){
//
//    }
//
//
    public void updateAppPositive(String tittle){
        clickSearchBar(driver);
        enterKeyword(tittle);
        clickApp(driver);
        clickUpdateButton(driver);
    }
}
