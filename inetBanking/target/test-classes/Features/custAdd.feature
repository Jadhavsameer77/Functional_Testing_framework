Feature: Inet Banking Testing Demo

  Scenario: Adding Customer to The Bank Portal
    Given manager is on login page
    When manager enter username and password
    And manager click on login button
    Then manager verify profile page
    Then manager press add customer button
    And manager enters user information into it
    Then manager verify cutomer is added or not
    Then manager click on logout button
    And maager exit portal
