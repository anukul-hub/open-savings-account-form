Feature: Open Savings Account Form
  As a user
  I want to fill and submit the Open Savings Account form
  So that I can apply for a new savings account

  Background:
    Given I am on the Open Savings Account page

  @PositiveScenario
  Scenario: Successfully submitting the savings account application with default test data
    When I fill the form with default test data
    And I click on the Submit Application button
    Then I should see a confirmation message "Your Savings Account application has been submitted successfully!"

#  @NegativeScenario
#  Scenario: Submitting the form with missing mandatory fields
#    When I leave the "fullname" field blank
#    And I click on the Submit Application button
#    Then I should see an error message "Full Name is required"
#
#  @ValidationScenario
#  Scenario: Submitting with invalid email format
#    When I enter "John Doe" in the "fullname" field
#    And I enter "invalid-email" in the "email" field
#    And I click on the Submit Application button
#    Then I should see an error message "Please enter a valid Email Address"
