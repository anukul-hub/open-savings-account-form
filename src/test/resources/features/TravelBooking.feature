@AllRegression
Feature: Travel Ticket Booking
  As a registered customer
  I want to search and book a travel ticket
  So that I can travel to my desired destination

  @SmokeTest
  Scenario: Successful one-way flight booking
    Given user is on the Travel Booking Home Page
    When user selects "One Way" trip option
    And user enters "Hyderabad" as source city
    And user enters "Delhi" as destination city
    And user selects journey date "2025-09-10"
    And clicks on the Search button
    Then available flights should be displayed
    When user selects the first available flight
    And clicks on Book Now
    Then user should be navigated to the Payment Page
    And booking summary with flight details should be displayed

  @BookingTravel
  Scenario: Booking attempt with missing travel details
    Given user is on the Travel Booking Home Page
    When user does not enter source and destination
    And clicks on the Search button
    Then an error message "Please enter Source and Destination" should be displayed

  @Regression
  Scenario Outline: Booking with multiple destinations
    Given user is on the Travel Booking Home Page
    When user selects "One Way" trip option
    And user enters "<source>" as source city
    And user enters "<destination>" as destination city
    And user selects journey date "<date>"
    And clicks on the Search button
    Then available flights should be displayed

    Examples:
      | source    | destination | date       |
      | Hyderabad | Mumbai      | 2025-09-12 |
      | Bangalore | Chennai     | 2025-09-15 |
      | Pune      | Goa         | 2025-09-18 |
