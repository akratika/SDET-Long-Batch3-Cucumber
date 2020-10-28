@alchemyJobs_3
Feature: Posting a job using parameterization

@test3
Scenario: Post a job using details passed from the Feature file
Given Open browser with ​alchemy Jobs site​
When Go to Post a Job page
Then Read job information from the Feature file table and fill in the details
And Click submit
And Go to the Jobs page
And Confirm job listing is shown on page
And Close the browser

