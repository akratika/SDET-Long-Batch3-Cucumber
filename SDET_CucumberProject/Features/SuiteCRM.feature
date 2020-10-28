@suiteCRM
Feature: Activities for SuiteCRM using cucumber 

Background: Open the browser to the ​Alchemy CRM​ site and login
Given Open the Alchemy CRM​ site
When Submit username and password
Then Verify user is logged in

@countingdashlets
Scenario: Open the homepage and count the number of the dashlets on the page
Given User is logged into alchemy CRM site
Then Count the number of Dashlets on the homepage
And Print the number and title of each Dashlet into the console
And Close the browser

@createLeads
Scenario Outline: Open the Leads page and add multiple lead accounts using values passed from  Feature file
Given Navigate to Sales -> Leads -> Create Lead
When Fill in leads"<Salutation>","<FirstName>","<LastName>","<MobileNumber>","<AccountName>","<Email>"
Then Click Save to finish
And Navigate to the View Leads page to see results
And Close the browser

Examples:
| Salutation | FirstName | LastName | MobileNumber | AccountName | Email |
| Ms. | Kratika | A | 987654321 | Kratika A | kratika@test.com |
| Ms. | Kratika | A | 987654321 | Kratika A | kratika@test.com |
| Ms. | Kratika | A | 987654321 | Kratika A | kratika@test.com |

@scheduleMeetings
Scenario Outline: To schedule a meeting and include at least 3 invitees
Given Navigate to Activities -> Meetings -> Schedule a Meeting
When Enter the details of the meeting
Then Search for members and add them to the meeting "<FirstName>","<LastName>"
And Click Save for meetings
And Navigate to View Meetings page and confirm creation of the meeting
And Close the browser

Examples:
| FirstName | LastName | 
| Kratika | A | 
| test | test |
| Abbie | Bran | 

@testaddProducts
Scenario Outline: To use an Examples table to add products
Given Navigate to All -> Products-> Create Product
When Retrieve information about the product "<ProductName>","<Price>","<Description>"
Then Click Save under products
And Go to the View Products page to see all products listed
And Close the browser

Examples:
| ProductName | Price | Description |
| Test Product | 50 | test product |
| Test Product | 65 | test product |
| Test Product | 85 | test product |
