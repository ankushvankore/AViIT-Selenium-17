Feature: Validate Title of Google
  Scenario: To validate title of Google home page
    Given Open Google
    When Capture title of Google
    Then Title should be Google