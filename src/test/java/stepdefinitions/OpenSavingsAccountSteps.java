package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.OpenSavingsAccountPage;

public class OpenSavingsAccountSteps {

    WebDriver driver = DriverFactory.getDriver();
    OpenSavingsAccountPage accountPage = new OpenSavingsAccountPage(driver);

    @Given("I am on the Open Savings Account page")
    public void i_am_on_the_open_savings_account_page() {
        driver.get("file:///C:/Users/anuku/Desktop/wipro/Saving%20account%20form.html"); // update with actual URL
    }

    @When("I enter {string} in the {string} field")
    public void i_enter_in_the_field(String value, String fieldId) {
        accountPage.enterText(fieldId, value);
    }

    @When("I select {string} from the {string} dropdown")
    public void i_select_from_the_dropdown(String value, String fieldId) {
        accountPage.selectDropdown(fieldId, value);
    }

    @When("I click on the Submit Application button")
    public void i_click_on_the_submit_application_button() {
        accountPage.clickSubmit();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String message) {
        // Implement actual validation here
        System.out.println("Validation: " + message);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String message) {
        // Implement actual validation here
        System.out.println("Validation Error: " + message);
    }

    @When("I leave the {string} field blank")
    public void i_leave_the_field_blank(String fieldId) {
        accountPage.leaveFieldBlank(fieldId);
    }

}
