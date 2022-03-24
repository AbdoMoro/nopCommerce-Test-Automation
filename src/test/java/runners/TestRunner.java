package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "resources/features",
        glue = "stepDefinitions",
        tags = "@Smoke",
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        dryRun = false

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
