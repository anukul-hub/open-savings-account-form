package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("***** Starting Scenario: " + scenario.getName() + " *****");

        // Load config before starting driver
        ConfigReader.loadConfig();

        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot on failure
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Screenshot");
            System.out.println("Screenshot captured for failed scenario: " + scenario.getName());
        }

        // Quit driver after each scenario
        DriverFactory.quitDriver();

        System.out.println("***** Finished Scenario: " + scenario.getName() + " *****");
    }
}
