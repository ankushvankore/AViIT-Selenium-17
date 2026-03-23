Feature: Search Functionality on Google
  Scenario: To validate search functionality on google
    Given Open Google In Chrome
    When Enter keyword to search
    And Hit enter
    Then A valid search result should display