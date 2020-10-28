@orangeHRM
Feature: Creating a job vacancy

Background: User is logged in
Given Open the HRM page
When User submit username and password
Then User is logged in

@testjobvacancy
Scenario: To create a job vacancy for "DevOps Engineer"
Given Navigate to the Recruitment page
When Click on the Vacancies menu item to navigate to the vacancies page
Then Click on the Add button to navigate to the Add Job Vacancy form
And Fill out the necessary details
And Click the Save button to save the vacancy
And Verify that the vacancy was created
And Close the browser

@testcandidaterecruitment
Scenario: Add information about a candidate for recruitment
Given Navigate to the Recruitment page and click on the Add button to add candidate information
When On the next page,fill in the details of the candidate
Then Upload a resume docx or pdf to the form
And Click Save
And Navigate back to the Recruitments page to confirm candidate entry
And Close the browser

@testmultipleemployees
Scenario Outline: Add multiple employees using an the Examples table
Given Find the PIM Option in the menu and click it​.
When Click the Add button to add a new Employee
Then Fill in "<FirstName>","<LastName>","<Username>","<Password>","<ConfirmPassword>" and click Save
And Verify that the employees have been created
And Close the browser

Examples:
| FirstName | LastName | Username | Password | ConfirmPassword |
| IBM | Employee | ibm | pa$$w0rd | pa$$w0rd |
| IBM | Employee | ibm | pa$$w0rd | pa$$w0rd |
| IBM | Employee | ibm | pa$$w0rd | pa$$w0rd |

@testmultiplevacancies
Scenario Outline: Creating multiple vacancies using data from Examples table
Given Navigate to the Recruitment page
When Click on the Vacancies menu item to navigate to the vacancies page
Then Click on the Add button to navigate to the Add Job Vacancy form
And Fill "<JobTitle>","<VacancyName>","<HiringManager>","<NumberOfPositions>","<Description>"
And Click the Save button to save the vacancy
And Repeat untill all the vacancies have been created
And Verify all the vacancies have been successfully created
And Close the browser

Examples:
| JobTitle | VacancyName | HiringManager | NumberOfPositions | Description |
| Automation Test Engineer | Automation Testing | Tony Stark | 4 | Automation with Cucumber Experience |
| Automation Test Engineer | Automation Testing | Tony Stark | 5 | Automation with Cucumber Experience |
| Automation Test Engineer | Automation Testing | Tony Stark | 6 | Automation with Cucumber Experience |
