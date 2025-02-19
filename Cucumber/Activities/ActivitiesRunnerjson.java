package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    plugin = {"json:target/json-report.json"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}
