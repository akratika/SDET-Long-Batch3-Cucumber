package testProject.SDET_CucumberTestProject;

public interface PageObjects_orangeHRM {
	
	//Test1
	public final static String username = "//input[@id='txtUsername']";
	public final static String pass = "//input[@id='txtPassword']";
	public final static String login_button = "//input[@id='btnLogin']";
	public final static String dashboard_tab = "//a[@id='menu_dashboard_index']";
	public final static String recruitment_tab = "//a[@id='menu_recruitment_viewRecruitmentModule']";
	//vacancy details
	public final static String vacancy_tab = "//a[@id='menu_recruitment_viewJobVacancy']"; 
	public final static String vacancies_text = "//div[@id='srchVacancy']//h1"; 
	public final static String vacancy_addButton = "//input[@id='btnAdd']";
	public final static String add_job_vacancy_text = "//div[@id='addJobVacancy']//h1";
	public final static String add_job_title = "//select[@id='addJobVacancy_jobTitle']";
	public final static String add_vacancy_name = "//input[@id='addJobVacancy_name']";
	public final static String add_hiring_manager = "//input[@id='addJobVacancy_hiringManager']";
	public final static String add_no_of_positions="//input[@id='addJobVacancy_noOfPositions']";
	public final static String add_description="//textarea[@id='addJobVacancy_description']";
	public final static String add_saveButton = "//input[@id='btnSave']";
	public final static String edit_vacancy_button = "//input[@id='btnSave' and @value='Edit']";
	public final static String job_title_ddn= "//select[@id='vacancySearch_jobTitle']";
	public final static String vacancy_ddn = "//select[@id='vacancySearch_jobVacancy']";
	public final static String vacancies_searchButton= "//input[@id='btnSrch']";
	public final static String vacancy_list = "//a[text()='Automation Test Engineer1']";
	//Candidate Details
	public final static String candidates_tab="//a[@id='menu_recruitment_viewCandidates']";
	public final static String candidates_text="//div[@id='srchCandidates']/div/h1";
	public final static String candidates_add_button="//input[@id='btnAdd']";
	public final static String addCandidate_firstName="//input[@id='addCandidate_firstName']";
	public final static String addCandidate_middleName="//input[@id='addCandidate_middleName']";
	public final static String addCandidate_lastName = "//input[@id='addCandidate_lastName']";
	public final static String addCandidate_email = "//input[@id='addCandidate_email']";
	public final static String addCandidate_contactno = "//input[@id='addCandidate_contactNo']";
	public final static String addCandidate_jobVacancy="//select[@id='addCandidate_vacancy']";
	public final static String addCandidate_resumeFile="//input[@id='addCandidate_resume']";
	public final static String addCandidate_consentToKeepData_checkbox = "//input[@id='addCandidate_consentToKeepData']";
	public final static String addCandidate_saveButton="//input[@id='btnSave']";
	public final static String candidate_result_column="//table[@id='resultTable']/tbody/tr[1]/td[3]/a";
	
	//PIM details
	public final static String pim_tab = "//a[@id='menu_pim_viewPimModule']";
	public final static String employee_list_Tab="//a[@id='menu_pim_viewEmployeeList']";
	public final static String add_employee_tab="//a[@id='menu_pim_addEmployee']";
	public final static String addEmployee_firstName="//input[@id='firstName']";
	public final static String addEmployee_lastName="//input[@id='lastName']";
	public final static String addEmployee_employeeId="//input[@id='employeeId']";
	public final static String addEmployee_createLoginDetails_checkbox="//input[@id='chkLogin']";
	public final static String addEmployee_saveButton="//input[@id='btnSave' and @value='Save']";
	public final static String addEmployee_username= "//input[@id='user_name']";
	public final static String addEmployee_password="//input[@id='user_password']";
	public final static String addEmployee_confirmPassword="//input[@id='re_password']";
	public final static String employee_personalData_employeeID="//input[@id='personal_txtEmployeeId']";
	public final static String search_employee_id="//input[@id='empsearch_id']";
	public final static String employee_searchButton="//input[@id='searchBtn']";
	public final static String employee_result_employeeID_column="//table[@id='resultTable']//tbody/tr/td[2]/a";
	
}
