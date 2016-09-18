Feature: Form Auth
  Scenario: Login with invalid credentials
    Given The user navigate to the site
    And Enters invalid username and invalid password
    When the user clicks Login button
    Then Error message appears

