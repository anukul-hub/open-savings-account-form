package hooks;

import com.aventstack.extentreports.ExtentTest;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.ExtentManager;

public class Hooks {

    private WebDriver driver;
    private ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("***** Starting Scenario: " + scenario.getName() + " *****");

        // Load config
        ConfigReader.loadConfig();

        driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();

        // Create Extent Test
        test = ExtentManager.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Screenshot");

            // Log failure in Extent Report
            ExtentManager.getTest().fail("Scenario failed: " + scenario.getName())
                    .addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
        } else {
            ExtentManager.getTest().pass("Scenario passed: " + scenario.getName());
        }

        DriverFactory.quitDriver();
        ExtentManager.flush();

        System.out.println("***** Finished Scenario: " + scenario.getName() + " *****");
    }
}
