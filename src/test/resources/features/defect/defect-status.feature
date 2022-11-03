@defectReporting
Feature: Defect Status

#Declarative Style

    Background:
        Given The employee is on the login page
        When The employee types in "ryeGuy" into the username input
        When The employee types in "coolbeans" into the password input
        When The employee clicks on the login button
    Scenario: Change Status
        Given The tester is on the Home Page
        Then The tester "ryeGuy" can can see only defects assigned to them
        When The tester changes to defect to any status
        Then The tester should see the defect has a different status