Feature: Automobile test
  Scenario: To validate automobile test
    Given Launch Insurance project
    When Click on Automobile link
    When Select make as "BMW"
    When Enter engine performance as "1000"
    When Enter date of manufacture as "03/02/2026"
    When Select no of seats as "3"
    When Select fuel type as "Petrol"
    Then Test pass
