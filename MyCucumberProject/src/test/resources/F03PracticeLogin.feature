Feature: Login on practice.expandtesting.com/login

  Background:
    Given Open practiceTesting site
  Scenario: To validate correct username password
    When Enter valid Username
    When Enter valid Password
    And Click on Login button
    Then Logged-in screen should open

  Scenario: To validate invalid username password
    When Enter invalid username
    When Enter invalid password
    And User clicks on login button
    Then Error message should display