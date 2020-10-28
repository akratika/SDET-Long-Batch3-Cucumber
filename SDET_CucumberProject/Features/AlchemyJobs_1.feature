@alchemyJobs_1
Feature: Create a new User

@test1
Scenario: Visit the site’s backend and create a new user
Given User is on alchemy login Page
When User is logged in as "root" and "pa$$w0rd"
Then User clicks on "Users" on the left hand menu
And User clicks on "Add New" button
And Verify that user was created successfully
And Close the browser