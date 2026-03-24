@AllTests
Feature: Selenium links
  Background:
    Given Launch url as "https://www.selenium.dev/"

    @SmokeTest
    Scenario: To validate Downloads Link
      When Click on Downloads Link
      Then Downloads page should open

    @DocumentationTest
    Scenario: To validate Documentations Link
      When Click on Documentation Link
      Then Documentations page should open

    @ProjectTest
    Scenario: To validate Projects link
      When Click on Projects link
      Then Projects page should open

    @SupportTest
    Scenario: To Validate Support link
      When Click on Support link
      Then Support page should open
