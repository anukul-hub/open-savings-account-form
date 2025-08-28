package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenSavingsAccountPage {

    WebDriver driver;

    // Constructor
    public OpenSavingsAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Dynamic locator for input fields (text, email, tel, number, date)
    private WebElement getInputField(String fieldId) {
        return driver.findElement(By.xpath("//input[@id='" + fieldId + "']"));
    }

    // Generic method to enter text in a field
    public void enterText(String fieldId, String value) {
        WebElement element = getInputField(fieldId);
        element.clear();
        element.sendKeys(value);
    }

    // For dropdowns
    public void selectDropdown(String fieldId, String value) {
        WebElement dropdown = driver.findElement(By.id(fieldId));
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    // For submit button
    public void clickSubmit() {
        driver.findElement(By.xpath("//button[text()='Submit Application']")).click();
    }

    // Already inside OpenSavingsAccountPage class

    // Enter blank value (clear field only)
    public void leaveFieldBlank(String fieldId) {
        WebElement element = getInputField(fieldId);
        element.clear();
    }
    // Get validation/error message by text
    public String getErrorMessage(String expectedText) {
        WebElement errorElement = driver.findElement(
                By.xpath("//*[contains(text(),'" + expectedText + "')]")
        );
        return errorElement.getText();
    }


}
