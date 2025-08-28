Feature: Login functionality


  Scenario: Successful login with valid credentials
    Given  user navigate to the "https://www.mycontactform.com/"
    When user enters valid username "qatrainer" and valid password "admin123"
    And clicks on the Login button
    Then user should be navigated to the Home Page
    Then user see the welcome message as "Welcome qatrainer"
    When user clicks on signout link under login page
    Then user should navigate to the home page
   	
   	