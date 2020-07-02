package steps;

import java.io.File;
import java.io.IOException;

import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import test.BaseClass;

public class Hooks extends BaseClass {

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
    }
}
