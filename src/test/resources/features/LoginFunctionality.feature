@AllRegression
Feature: Login functionality


  @ValidLoginTest @SmokeTest
  Scenario: Successful login with valid credentials
    Given  user navigate to the "https://www.mycontactform.com/"
    When user enters valid username "qatrainer" and valid password "admin123"
    And clicks on the Login button
    Then user should be navigated to the Home Page
    Then user see the welcome message as "Welcome qatrainer"
    And a welcome message should be displayed

  @Regression
  Scenario: Login attempt with invalid credentials
    Given  user navigate to the "https://www.mycontactform.com/"
    When user enters invalid username "wronguser" and invalid password "wrongpass"
    And clicks on the Login button
    Then an error message "Invalid username or password" should be displayed


  @BookingTravel
  Scenario Outline: Login attempt with multiple login credentials
    Given user navigate to the "https://www.mycontactform.com/"
    When user enters invalid username "<username>" and invalid password "<password>"
    And clicks on the Login button
    Then user error message should be displayed as "<message>"

    Examples:
      | username  | password | message                            |
      | qatrainer | admin123 | Welcome qatrainer                  |
      | qatrainer | admin    | Incorrect login, please try again. |
      | tester1   | admin123 | Enter you login details.           |
	