Feature: Creating new individual in salesforce application

Background:
Given Enter the Username as 'priya13ravi@testleaf.com'
And Enter the Password as 'Paramesh2710**'
And Login
And Select view All from toggle option
And Select Individiaul from App Launcher



Scenario Outline:
When Click new Individual
And Enter lastname for individual <lastname>
And Select Save button
Then Validate New individual Creation <lastname>

Examples:
|lastname|
|Prasad|
|sanju|
|waran|

