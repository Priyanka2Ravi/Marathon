Feature: Editing an existing individual in salesforce application

Background:
Given Enter the Username as 'priya13ravi@testleaf.com'
And Enter the Password as 'Paramesh2710**'
And Login
And Select view All from toggle option
And Select Individiaul from App Launcher



Scenario Outline:
When Search with lastname as <lastname>
And  Click edit from dropdown
And Enter MR as salutation
And Provide Firstname as <firstname>
And Click Save button on edit page
Then Validate the firstname of edited individual <firstname>

Examples:
|lastname|firstname|
|Prasad|Karthik|
|sanju|samson|
|waran|Paramesh|