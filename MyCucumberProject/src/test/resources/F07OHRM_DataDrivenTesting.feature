Feature: OHRM Login via DDF

  Scenario Outline: To validate login functionality on OHRM
    Given Launch OHRM site
    When Enter username as "<UserName>"
    When Enter password as "<Password>"
    When Click on Login
    Then Dashboard page should open

    Examples:
      | UserName    | Password       |
      | admin       | admin123       |
      | ila         | ila123         |
      | admin       | admin123       |
      | shrivardhan | shrivardhan123 |