Feature: Login scenario test for Book cart application

  Background:
    Given load to book cart main page

  Scenario Outline: Login to Book cart and check for login functionality
    When user click on login button, login page should be displayed
    And user takes snapshot
    Then user log into the application with with "<username>" and "<password>"
    And user takes snapshot
    Examples:
      | username | password |
      | ortoni   | pass1234 |
      | cucumber | Pass1234 |
