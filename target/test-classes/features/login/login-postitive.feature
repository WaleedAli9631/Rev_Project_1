@login
Feature: Login

    Scenario Outline: Login with correct credentials
        Given The employee is on the login page
        When  The employee types in <username> into the username input
        When The employee types in <password> into the password input
        When The employee clicks on the login button
        Then the employee should be on the <role> page
        Then The employee should see their name <fname> <lname> on the home page
    
    Examples:
        | username   | password | role    | fname   | lname     |
        | "g8tor"     | "chomp!"  | "Manager" | "Patty"  | "Pastiche"  |
        | "ryeGuy"     | "coolbeans"| "Tester"  | "Fakey"   | "McFakeFace"|
        | "cavalier89" | "alucard"  | "Tester"  | "Dracula" | "Fangs"    |