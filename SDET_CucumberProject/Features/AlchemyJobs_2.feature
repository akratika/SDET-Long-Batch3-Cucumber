@alchemyJobs_2
Feature: Searching for jobs using XPath

@test2
Scenario: Searching for jobs and applying to them using XPath
Given Open browser with Alchemy Jobs site​
When User navigate to Jobs page
Then Find the Keywords search input field and Type in keywords to search for jobs and change the Job type
And Find the filter using XPath and filter job type to show only “Full Time” jobs
And Find a job listing using XPath and it to see job details
And Find the title of the job listing using XPath and print it to the console
And Find and Click on the “Apply for job” button
And Close the browser

