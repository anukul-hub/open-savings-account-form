package stepdefinitions;

import org.openqa.selenium.WebDriver;


import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginPageSteps {

    WebDriver driver;
    private LoginPage login;

    @Given("user navigate to the {string}")
    public void user_navigate_to_the(String appurl) {
//		DriverFactory.launchBrowser("chrome");
        driver = DriverFactory.getDriver();
        login = new LoginPage(DriverFactory.getDriver());
        driver.get(appurl);
    }

    @When("user enters valid username {string} and valid password {string}")
    public void user_enters_valid_username_and_valid_password(String un, String pw) {

        login.insertUserName(un);
        login.insertPassword(pw);
    }

    @When("clicks on the Login button")
    public void clicks_on_the_login_button() {
        login.clickSubmit();
    }

    @Then("user should be navigated to the Home Page")
    public void user_should_be_navigated_to_the_home_page() {

    }

    @Then("user see the welcome message as {string}")
    public void user_see_the_welcome_message_as(String string) {
        login.getWelcomeMessage();
    }

    @When("user clicks on signout link under login page")
    public void user_clicks_on_signout_link_under_login_page() {
        login.clickSignOut();
    }

    @Then("user should navigate to the home page")
    public void user_should_navigate_to_the_home_page() {

    }


}
