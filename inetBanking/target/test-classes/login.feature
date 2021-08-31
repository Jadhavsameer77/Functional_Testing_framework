Feature: InetBankin Testing

  Scenario: Login Functionality
    Given user is on login page
    When user enter username and password
    And user click on login button
    Then user is on user profile page
    Then user verify page
    And user press logout button
