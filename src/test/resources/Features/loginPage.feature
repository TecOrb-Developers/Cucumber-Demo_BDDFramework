Feature: Login Feature

	Scenario: Valid Login scenario
	  Given User is on homepage
	  When User navigates to login page
	  Then user enters username and Password
	  And User click on login button

  Scenario: Login with incorrect username and password to fail
    Given User is on homepage
  	When User navigates to login page
    And I enter username as "ankesh@tecorb.co" and password as "123456789"
    And User click on login button
    Then I should see the alert message