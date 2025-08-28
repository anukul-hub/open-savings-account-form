package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\features\\OpenSavingsAccountForm.feature",
        glue = {"stepdefinitions", "hooks"},
//tags = "@ValidLoginTest",
        dryRun = false,
        monochrome = false,

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },
        tags = "@PositiveScenario or @NegativeScenario @ValidationScenario"

)

public class TestRunnerOpenSavingsAccountForm {
}
