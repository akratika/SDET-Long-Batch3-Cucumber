@alchemyJobs_4
Feature: Using Examples table to post a job

@test4
Scenario Outline: Rewrite activity 3 using a scenario outline and Examples table to post a job
Given Open browser with ​alchemy jobs site​
When Go to post a job page
Then Read job information "<Username>","<Password>","<JobTitle>","<JobType>","<JobDescription>" and fill in the details
And Click Submit
And Go to the jobs Page
And Confirm Job listing is shown on page
And Close the browser

Examples:
| Username | Password |            JobTitle              | JobType  |            JobDescription                  |
| root     | pa$$w0rd | Automation with Cucumber Testing | Full Time| Automation Tester with Cucumber experience |