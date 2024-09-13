Feature: View car Odometer
  User Story:As a user, I want to view car odometer info on the Vehicles Odometers page.

  Background:
  @vehiclesOdometers
  Scenario: Drivers should see the default page as 1
    Given user is on the login page
    And user is on the home page
    When user select dropdown Fleets
    And user clicks Vehicle Odometer
    Then user should be see page number 1

  @vehiclesOdometers
  Scenario: Drivers should be see view per page 25
    Given user is on the login page
    And user is on the home page
    When user select dropdown Fleets
    And user clicks Vehicle Odometer
    Then user should be see view per page 25

@vehiclesOdometersSales
  Scenario: Store and Sales managers should see an error message
    Given user is on the login page
    And user is on the home page
    When user select dropdown Fleets
    And user clicks Vehicle Odometer
    Then Store and Sales managers should see an error message “You do not have permission to perform this action.”
