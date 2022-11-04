@matrix
Feature: Matrix

 Declarative Style

    Scenario: Create a New Matrix
        Given The employee is on the login page
        When The employee types in "g8tor" into the username input
        When The employee types in "chomp!" into the password input
        When The employee clicks on the login button
        Then A manager can pull up a form to make a new matrix
        When A manager creates a title for a matrix
        When A manager adds requirements to a matrix
        When A manager saves a matrix
        Then The matrix should be visible for all testers and managers

    Scenario Outline: Update Defects
        Given The employee is on the login page
        When The employee types in <username> into the username input
        When The employee types in <password> into the password input
        When The employee clicks on the login button
        Given The manager or tester clicks on Matrices
        Given A manager or tester has selected a matrix
        When A manager or tester adds or removes defects
        When A manager or tester confirms their changes
        Then Then the matrix should saved
        Examples:
            | username   | password |
            | "g8tor"     | "chomp!"  |
            | "ryeGuy"     | "coolbeans"|

    Scenario Outline: Update Test Cases
        Given The employee is on the login page
        When The employee types in <username> into the username input
        When The employee types in <password> into the password input
        When The employee clicks on the login button
        Given The manager or tester clicks on Matrices
        Given A manager or tester has selected a matrix
        When A manager or tester adds or removes Test Cases
        When A manager or tester confirms their changes
        Then Then the matrix should saved
        Examples:
            | username   | password |
            | "g8tor"     | "chomp!"  |
            | "ryeGuy"     | "coolbeans"|


