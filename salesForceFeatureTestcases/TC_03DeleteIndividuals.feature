Feature: Editing an existing individual in salesforce application

Background:
Given Enter the Username as 'priya13ravi@testleaf.com'
And Enter the Password as 'Paramesh2710**'
And Login
And Select view All from toggle option
And Select Individiaul from App Launcher



Scenario Outline:
When Search with lastname as <lastname>
And  Click delete from dropdown
And Select Delete option
Then Validate Deletion of individual <lastname>

Examples:
|lastname|
|Prasad|
|sanju|
|waran|
