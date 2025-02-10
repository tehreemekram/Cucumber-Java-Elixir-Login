Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username and password
    And user clicks on login
    Then user is navigated to the home page
    When user clicks on logout
    Then user is navigated back to the login page
    And close the browser