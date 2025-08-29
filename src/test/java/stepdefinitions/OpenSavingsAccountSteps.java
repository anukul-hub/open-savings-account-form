package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.OpenSavingsAccountPage;
import utils.ConfigReader;
import utils.TestDataReader;

public class OpenSavingsAccountSteps {

    WebDriver driver = DriverFactory.getDriver();
    OpenSavingsAccountPage accountPage = new OpenSavingsAccountPage(driver);

    @Given("I am on the Open Savings Account page")
    public void i_am_on_the_open_savings_account_page() {
        String url = ConfigReader.getProperty("url");
        driver.get(url);
    }
    @When("I fill the form with default test data")
    public void i_fill_the_form_with_default_test_data() {
        accountPage.enterText("fullname", TestDataReader.getProperty("fullname"));
        accountPage.enterText("fathername", TestDataReader.getProperty("fathername"));
        accountPage.enterText("occupation", TestDataReader.getProperty("occupation"));
        accountPage.enterText("companyname", TestDataReader.getProperty("companyname"));
        accountPage.enterText("dob", TestDataReader.getProperty("dob"));
        accountPage.enterText("email", TestDataReader.getProperty("email"));
        accountPage.enterText("phone", TestDataReader.getProperty("phone"));
        accountPage.enterText("address", TestDataReader.getProperty("address"));
        accountPage.enterText("idProof", TestDataReader.getProperty("idProof"));
        accountPage.selectDropdown("accountType", TestDataReader.getProperty("accountType"));
        accountPage.enterText("initialDeposit", TestDataReader.getProperty("initialDeposit"));
    }



//    @When("I enter {string} in the {string} field")
//    public void i_enter_in_the_field(String value, String fieldId) {
//        accountPage.enterText(fieldId, value);
//    }
//
//    @When("I select {string} from the {string} dropdown")
//    public void i_select_from_the_dropdown(String value, String fieldId) {
//        accountPage.selectDropdown(fieldId, value);
//    }

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
