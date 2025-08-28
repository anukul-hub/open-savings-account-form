package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/OpenSavingsAccountForm.feature",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"   // Extent plugin

        },
        tags = "@PositiveScenario or @NegativeScenario or @ValidationScenario"
)
public class TestRunnerOpenSavingsAccountForm extends AbstractTestNGCucumberTests {
}
