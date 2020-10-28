package stepDefinitions;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testProject.SDET_CucumberTestProject.DriverSetup;
import testProject.SDET_CucumberTestProject.PageObjects_orangeHRM;

public class Background_steps extends DriverSetup implements PageObjects_orangeHRM{
	//DriverSetup setup = new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
	int key;
	static String vacancyNameText;
	Select select;
	static String candidateName;
	static List<String> employeeID= new ArrayList<String>();
	
	@Given("^Open the HRM page$")
	public void openHRM() {
		driver= propertySetup();
		wait= new WebDriverWait(driver, 20);
		Random random= new Random();
		key= random.nextInt(3000);
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@When("^User submit username and password$")
	public void submit_username_and_password() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(username)));
		driver.findElement(By.xpath(username)).sendKeys("orange");
		driver.findElement(By.xpath(pass)).sendKeys("orangepassword123");
		driver.findElement(By.xpath(login_button)).click();
	}
	
	@Then("^User is logged in$")
	public void user_is_logged_in() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboard_tab)));
		if(driver.findElement(By.xpath(dashboard_tab)).isDisplayed()) {
			System.out.println("Login successful.");
		}else
			System.out.println("Login Unsuccessful.");
	}
	@Given("^Navigate to the Recruitment page$")
	public void navigate_to_recruitment_page() {
		driver.findElement(By.xpath(recruitment_tab)).click();
	}
	
	@When("^Click on the Vacancies menu item to navigate to the vacancies page$")
	public void click_vacancies_menu() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(vacancy_tab)));
		driver.findElement(By.xpath(vacancy_tab)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(vacancies_text)));
		if(driver.findElement(By.xpath(vacancies_text)).isDisplayed()) {
			System.out.println("Vacancies Page displayed");
		}else
			System.out.println("Issue in Vacancies page");
	}
	
	@Then("^Click on the Add button to navigate to the Add Job Vacancy form$")
	public void click_add_button_and_navigate_to_add_job_vacancy() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(vacancy_addButton)));
		driver.findElement(By.xpath(vacancy_addButton)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(add_job_vacancy_text)));
		if(driver.findElement(By.xpath(add_job_vacancy_text)).isDisplayed()) {
			System.out.println("Add Job Vacancy form displayed");
		}else
			System.out.println("Issue in Add Job Vacancy form");
	}
	
	@And("^Fill out the necessary details$")
	public void fill_necessary_details() {
		
		select= new Select(driver.findElement(By.xpath(add_job_title)));
		select.selectByVisibleText("Automation Test Engineer");
		vacancyNameText = "Automation Test Engineer "+ key;
		driver.findElement(By.xpath(add_vacancy_name)).sendKeys(vacancyNameText);
		driver.findElement(By.xpath(add_hiring_manager)).sendKeys("Tony Stark");
		driver.findElement(By.xpath(add_no_of_positions)).sendKeys("5");
		driver.findElement(By.xpath(add_description)).sendKeys("Automation with Cucumber Experience");
		
	}
	
	@And("^Click the Save button to save the vacancy$")
	public void click_save_button() {
		driver.findElement(By.xpath(add_saveButton)).click();
	}
	
	@And("^Verify that the vacancy was created$")
	public void verify_vacancy() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(edit_vacancy_button)));
		driver.findElement(By.xpath(vacancy_tab)).click();
		select= new Select(driver.findElement(By.xpath(job_title_ddn)));
		select.selectByVisibleText("Automation Test Engineer");
		
		Select selVac= new Select(driver.findElement(By.xpath(vacancy_ddn)));
		selVac.selectByVisibleText(vacancyNameText);
		
		driver.findElement(By.xpath(vacancies_searchButton)).click();
		List<WebElement> vacancies = driver.findElements(By.xpath(vacancy_list));
		if(vacancies.size()>1) {
			System.out.println("More than 1 vacancy found");
		}else {
			System.out.println("Vacancy Created successfully!");
		}
	}
	
	//Add information about a candidate for recruitment
	
	@Given("^Navigate to the Recruitment page and click on the Add button to add candidate information$")
	public void navigate_to_recruitment_page_click_add_button() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(recruitment_tab)));
		driver.findElement(By.xpath(recruitment_tab)).click();
		driver.findElement(By.xpath(candidates_tab)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(candidates_text)));
		driver.findElement(By.xpath(candidates_add_button)).click();
	}
	
	@When("^On the next page,fill in the details of the candidate$")
	public void fill_candidate_details() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addCandidate_firstName)));
		driver.findElement(By.xpath(addCandidate_firstName)).sendKeys("Kratika");
		driver.findElement(By.xpath(addCandidate_middleName)).sendKeys("A");
		driver.findElement(By.xpath(addCandidate_lastName)).sendKeys(""+key);
		candidateName= "Kratika "+"A "+key;
		driver.findElement(By.xpath(addCandidate_email)).sendKeys("kratikaTest01@alchemy.com");
		driver.findElement(By.xpath(addCandidate_contactno)).sendKeys("123456789");
		select= new Select(driver.findElement(By.xpath(addCandidate_jobVacancy)));
		select.selectByVisibleText(vacancyNameText);
		driver.findElement(By.xpath(addCandidate_consentToKeepData_checkbox)).click();
	}
	
	@Then("^Upload a resume docx or pdf to the form$")
	public void upload_resume() {
		//File file= new File("C:\\New folder\\AlchemyTestResume.docx");
		driver.findElement(By.xpath(addCandidate_resumeFile)).sendKeys("C:\\New folder\\AlchemyTestResume.docx");
		
	}
	
	@And("^Click Save$")
	public void addCandidate_click_save() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addCandidate_saveButton)));
		driver.findElement(By.xpath(addCandidate_saveButton)).click();
		
	}
	
	@And("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void navigate_to_recruitment_page_confirm_candidate() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(recruitment_tab)));
		driver.findElement(By.xpath(recruitment_tab)).click();
		driver.findElement(By.xpath(candidates_tab)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(candidate_result_column)));
		String candidateColumnText= driver.findElement(By.xpath(candidate_result_column)).getText();
		if(candidateColumnText.equals(candidateName)) {
			System.out.println("Candidate "+candidateName+" verification completed");
		}
		
	}
	
	//Add multiple employees using an the Examples table
	
	@Given("^Find the PIM Option in the menu and click it​\\.$")
	public void find_the_PIM_Option_in_the_menu_and_click_it​() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboard_tab)));
		driver.findElement(By.xpath(pim_tab)).click();
	}
	
	
	@When("^Click the Add button to add a new Employee$")
	public void click_add_button_to_add_new_employee() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(add_employee_tab)));
		driver.findElement(By.xpath(add_employee_tab)).click();
	}
	
	@Then("^Fill in \\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\" and click Save$")
	public void fill_fields_and_click_save(String firstName,String lastName,String userName,String password,String confirmPassword) {
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(add_employee_tab)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addEmployee_firstName)));
		driver.findElement(By.xpath(addEmployee_createLoginDetails_checkbox)).click();
		driver.findElement(By.xpath(addEmployee_firstName)).sendKeys(firstName);
		String emplname = lastName +" "+key;
		driver.findElement(By.xpath(addEmployee_lastName)).sendKeys(emplname);
		employeeID.add(driver.findElement(By.xpath(addEmployee_employeeId)).getAttribute("value"));
		String uname= userName+key;
		driver.findElement(By.xpath(addEmployee_username)).sendKeys(uname);
		driver.findElement(By.xpath(addEmployee_password)).sendKeys(password);		
		driver.findElement(By.xpath(addEmployee_confirmPassword)).sendKeys(confirmPassword);
		driver.findElement(By.xpath(addCandidate_saveButton)).click();
	}
	
	
	@And("^Verify that the employees have been created$")
	public void verify_employees_created() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(employee_list_Tab)));
		driver.findElement(By.xpath(employee_list_Tab)).click();
		for(String str: employeeID) {
			driver.findElement(By.xpath(search_employee_id)).clear();
			driver.findElement(By.xpath(search_employee_id)).sendKeys(str);
			driver.findElement(By.xpath(employee_searchButton)).click();
			String idvalue= driver.findElement(By.xpath(employee_result_employeeID_column)).getText();
			if(str.equals(idvalue)) {
				System.out.println("Employee "+str+" validation successfull.");
			}else
				System.out.println("Issue in employee "+str+" creation.");
		}
	}
	
	// 	Creating multiple vacancies using data from Examples table
	@And("^Fill \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fill_details_from_examples_table(String jobTitle, String vacancyName,String hiringManager,String positions,String description) {
		select= new Select(driver.findElement(By.xpath(add_job_title)));
		select.selectByVisibleText(jobTitle);
		vacancyNameText = vacancyName+" "+ key;
		driver.findElement(By.xpath(add_vacancy_name)).sendKeys(vacancyNameText);
		driver.findElement(By.xpath(add_hiring_manager)).sendKeys(hiringManager);
		driver.findElement(By.xpath(add_no_of_positions)).sendKeys(positions);
		driver.findElement(By.xpath(add_description)).sendKeys(description);
		
	}
	
	@And("^Repeat untill all the vacancies have been created$")
	public void repeat_untill_all_vacancies_created() {
		System.out.println("Vacancies through example table");
	}
	
	@And("^Verify all the vacancies have been successfully created$")
	public void verify_vacancies_created() {
		verify_vacancy();
	}
}
