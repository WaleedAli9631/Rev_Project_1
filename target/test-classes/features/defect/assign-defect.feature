@defectReporting
Feature: Assign Defect

    Scenario: Assign Defect
        Given The employee is on the login page
        When The employee types in "g8tor" into the username input
        When The employee types in "chomp!" into the password input
        When The employee clicks on the login button
#        Given The manager is logged in as a manager
        Given The manager is on the home page
        Then The manager should see pending defects
        When The manager clicks on the select button for a defect
        Then The defect description should appear in bold
        When The manager selects an tester from the drop down
        When The manager clicks assign
        Then The defect should disappear from the list
        When The user logs out
        Given The employee is on the login page
        When The employee types in "ryeGuy" into the username input
        When The employee types in "coolbeans" into the password input
        When The employee clicks on the login button
#        Given The assigned tester is on their home page
        Then The tester should see the pending defect