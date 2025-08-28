package hooks;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks {

    WebDriver driver;
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @BeforeAll
    public static void beforeAll() {
        try {
            Files.createDirectories(Paths.get("target/reports"));
            ExtentSparkReporter spark = new ExtentSparkReporter("target/reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Before
    public void setup(Scenario scenario) {
//// Browser from system property or TestNG parameter
//String browser = System.getProperty("browser", System.getProperty("selenium.browser", "chrome"));
//DriverFactory.launchBrowser(browser);

        DriverFactory.launchBrowser("chrome");
//	DriverFactory.getDriver();

        test.set(extent.createTest(scenario.getName()));
        test.get().assignCategory(scenario.getSourceTagNames().toArray(new String[0]));

    }


    @AfterStep
    public void afterStep(Scenario scenario) {
// Attach a screenshot for each step (optional). You can limit to failures only.
        if (scenario.isFailed()) {
            attachScreenshot(Status.FAIL, scenario);
        } else {
// Uncomment for step-wise screenshots
// attachScreenshot(Status.PASS, scenario);
        }
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            attachScreenshot(Status.PASS, scenario);
            test.get().log(Status.FAIL, "Scenario failed");
        } else {
            test.get().log(Status.PASS, "Scenario passed");
        }
        DriverFactory.getDriver();
        DriverFactory.quitBrowser();
    }


    @AfterAll
    public static void afterAll() {
        if (extent != null) {
            extent.flush();
        }
    }


    private void attachScreenshot(Status status, Scenario scenario) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            if (driver == null) return;
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            Path dest = Paths.get("target", "reports", "screenshots", name + "_" + time + ".png");
            Files.createDirectories(dest.getParent());
            FileUtils.copyFile(src, dest.toFile());
            test.get().addScreenCaptureFromPath(dest.toString());
        } catch (Exception e) {
            test.get().warning("Failed to capture screenshot: " + e.getMessage());
        }
    }
}

