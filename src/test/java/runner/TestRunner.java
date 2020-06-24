package runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        , monochrome = false
        , plugin = { "pretty", "html:target/results" }
        , glue = { "steps" }
        , strict = true
//        , tags = {"@RT-interact"}
)
public class TestRunner {
}
