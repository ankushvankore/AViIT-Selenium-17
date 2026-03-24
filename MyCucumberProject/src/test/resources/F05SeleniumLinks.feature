Feature: Selenium links
  Background:
    Given Launch url as "https://www.selenium.dev/"

    Scenario: To validate Downloads Link
      When Click on Downloads Link
      Then Downloads page should open

    Scenario: To validate Documentations Link
      When Click on Documentation Link
      Then Documentations page should open

    Scenario: To validate Projects link
      When Click on Projects link
      Then Projects page should open

    Scenario: To Validate Support link
      When Click on Support link
      Then Support page should open
