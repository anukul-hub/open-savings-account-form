Feature: Open Savings Account Form
  As a user
  I want to fill and submit the Open Savings Account form
  So that I can apply for a new savings account

  Background:
    Given I am on the Open Savings Account page

  @PositiveScenario
  Scenario: Successfully submitting the savings account application for Jason Momoa
    When I enter "Jason Momoa" in the "fullname" field
    And I enter "Joseph Momoa" in the "fathername" field
    And I enter "Actor" in the "occupation" field
    And I enter "Hollywood Film Industry" in the "companyname" field
    And I enter "1979-08-01" in the "dob" field
    And I enter "jason.momoa@example.com" in the "email" field
    And I enter "9876543210" in the "phone" field
    And I enter "Los Angeles, California, USA" in the "address" field
    And I enter "Passport - JM1979USA" in the "idProof" field
    And I select "Regular Savings" from the "accountType" dropdown
    And I enter "1000000" in the "initialDeposit" field
    And I click on the Submit Application button
    Then I should see a confirmation message "Your Savings Account application has been submitted successfully!"

  @NegativeScenario
  Scenario: Submitting the form with missing mandatory fields
    When I leave the "fullname" field blank
    And I click on the Submit Application button
    Then I should see an error message "Full Name is required"

  @ValidationScenario
  Scenario: Submitting with invalid email format
    When I enter "John Doe" in the "fullname" field
    And I enter "invalid-email" in the "email" field
    And I click on the Submit Application button
    Then I should see an error message "Please enter a valid Email Address"
