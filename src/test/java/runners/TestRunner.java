package runners;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\features\\loginPage.feature",
        glue = {"stepdefinitions", "hooks"},
//tags = "@ValidLoginTest",
        dryRun = false,
        monochrome = false,

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        }

)


public class TestRunner extends AbstractTestNGCucumberTests {
//@Override
//@DataProvider(parallel = true)
//public Object[][] scenarios() {
//return super.scenarios();
//}
}