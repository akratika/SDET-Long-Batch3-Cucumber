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
import testProject.SDET_CucumberTestProject.PageObjects_alchemyCRM;
import testProject.SDET_CucumberTestProject.PageObjects_orangeHRM;

public class suite_CRMProject extends DriverSetup implements PageObjects_alchemyCRM{
	//DriverSetup setup = new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
	int key;
	Select select;
	static String leadName;
	static String meetingSubject;
	static String productName;
	
	@Given("^Open the Alchemy CRM​ site$")
	public void openCRMsite() {
		driver= propertySetup();
		wait= new WebDriverWait(driver, 20);
		Random random= new Random();
		key= random.nextInt(3000);
		driver.get("https://alchemy.hguy.co/crm/");
	}
	
	@When("^Submit username and password$")
	public void submit_username_and_password() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(username)));
		driver.findElement(By.xpath(username)).sendKeys("admin");
		driver.findElement(By.xpath(pass)).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath(login_button)).click();
	}
	
	@Then("^Verify user is logged in$")
	public void user_is_logged_in() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(suiteCRM_dashboard_text)));
		if(driver.findElement(By.xpath(suiteCRM_dashboard_text)).isDisplayed()) {
			System.out.println("Login successful.");
		}else
			System.out.println("Login Unsuccessful.");
	}
	
	//Open the homepage and count the number of the dashlets on the page
	
	@Given("^User is logged into alchemy CRM site$")
	public void user_logged_into_alchemy_CRM_site() {
		if(driver.findElement(By.xpath(suiteCRM_dashboard_text)).isDisplayed()) {
			System.out.println("User is logged in");
		}else
			System.out.println("User is not logged in");
	}
		
	@Then("^Count the number of Dashlets on the homepage$")
	public void click_add_button_and_navigate_to_add_job_vacancy() {
		driver.findElement(By.xpath(suiteCRM_dashboard_text)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashlet_count)));
		List<WebElement> dashlets= driver.findElements(By.xpath(dashlet_count));
		int count_dashlets = dashlets.size();
		System.out.println("Dashlets count: "+count_dashlets);
	}
	
	@And("^Print the number and title of each Dashlet into the console$")
	public void print_number_title_of_each_dashlet(){
		List<WebElement> dashlets = driver.findElements(By.xpath(dashlets_text));
		int count=1;
		for(WebElement dashlet: dashlets) {
			String dashletText = dashlet.getText();
			System.out.println("Dashlet number "+count+" and Dashlet name: "+dashletText);
			count++;
		}
	}
	
	// Open the Leads page and add multiple lead accounts using values passed from  Feature file
	
	@Given("^Navigate to Sales -> Leads -> Create Lead$")
	public void navigate_to_recruitment_page_click_add_button() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(suiteCRM_dashboard_text)));
		driver.findElement(By.xpath(sales_link)).click();
		waitseconds(2);
		driver.findElement(By.xpath(leads_link)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(create_lead_button)));
		driver.findElement(By.xpath(create_lead_button)).click();
		System.out.println("Create lead button clicked.");
	}
	
	@When("^Fill in leads\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\"$")
	public void fill_create_lead_details(String sal,String fname,String lname, String mobno,String accname, String email) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(create_lead_salutation)));
		waitseconds(2);
		driver.findElement(By.xpath(create_lead_salutation)).click();
		select= new Select(driver.findElement(By.xpath(create_lead_salutation)));
		select.selectByVisibleText(sal);
		driver.findElement(By.xpath(create_lead_firstname)).sendKeys(fname);
		driver.findElement(By.xpath(create_lead_lastname)).sendKeys(lname+" "+key);
		leadName= sal+" "+fname+" "+lname+" "+key;
		driver.findElement(By.xpath(create_lead_mobile)).sendKeys(mobno);
		driver.findElement(By.xpath(create_lead_accountName)).sendKeys(accname);
		driver.findElement(By.xpath(create_lead_email)).sendKeys(email);
		
	}
	
	@Then("^Click Save to finish$")
	public void create_lead_save() {
		List<WebElement> saveButtons = driver.findElements(By.xpath(create_lead_save_buttons));
		for(WebElement saveButton: saveButtons) {
			saveButton.click();
			break;
		}
		if(driver.findElement(By.xpath("//input[@class='button' and @title='Save']")).isDisplayed()) {
			List<WebElement> save = driver.findElements(By.xpath("//input[@class='button' and @title='Save']"));
			for(WebElement s: save) {
				s.click();
				break;
			}
		}
	}
	
	@And("^Navigate to the View Leads page to see results$")
	public void navigate_to_view_leads_page_and_see_results() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(create_lead_module_title_after_save)));
		driver.findElement(By.xpath(view_leads_button)).click();
		waitseconds(2);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(view_leads_name_column_value)));
		String leadValue = driver.findElement(By.xpath(view_leads_name_column_value)).getText();
		if(leadValue.equals(leadName)){
			System.out.println("Lead created.");
		}else
			System.out.println("Issue in lead creation");
	}
	
	//To schedule a meeting and include at least 3 invitees
	
	@Given("^Navigate to Activities -> Meetings -> Schedule a Meeting$")
	public void navigate_to_schedule_meeting​() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(suiteCRM_dashboard_text)));
		driver.findElement(By.xpath(activities_link)).click();
		waitseconds(2);
		driver.findElement(By.xpath(meetings_link)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(schedule_meeting_button)));
		driver.findElement(By.xpath(schedule_meeting_button)).click();
	}
	
	
	@When("^Enter the details of the meeting$")
	public void enter_meeting_details() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(create_meeting_subject)));
		meetingSubject= "Test Meeting"+ key;
		waitseconds(2);
		driver.findElement(By.xpath(create_meeting_subject)).click();
		driver.findElement(By.xpath(create_meeting_subject)).sendKeys(meetingSubject);
		driver.findElement(By.xpath(create_meeting_location)).click();
		driver.findElement(By.xpath(create_meeting_location)).sendKeys("Webex");
		driver.findElement(By.xpath(create_meeting_duration)).click();
		select= new Select(driver.findElement(By.xpath(create_meeting_duration)));
		select.selectByVisibleText("1 hour");
		driver.findElement(By.xpath(create_meeting_description)).click();
		driver.findElement(By.xpath(create_meeting_description)).sendKeys("Meeting scheduled for revision");
	}
	
	@Then("^Search for members and add them to the meeting \"(.*)\",\"(.*)\"$")
	public void search_members(String fname, String lname) {
		driver.findElement(By.xpath(add_invitees_first_name)).sendKeys(fname);
		driver.findElement(By.xpath(add_invitees_last_name)).sendKeys(lname);
		driver.findElement(By.xpath(add_invitees_search_button)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(add_invitees_add_button)));
		driver.findElement(By.xpath(add_invitees_add_button)).click();
	}
	
	@And("^Click Save for meetings$")
	public void meeting_click_save() {
		List<WebElement> saveButtons = driver.findElements(By.xpath(create_meeting_save_buttons));
		for(WebElement saveButton: saveButtons) {
			saveButton.click();
			break;
		}
	}
	
	@And("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void navigate_to_view_meetings_confirm_meeting_creation() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(create_lead_module_title_after_save)));
		driver.findElement(By.xpath(view_meetings_button)).click();
		waitseconds(2);
		String meetingText = driver.findElement(By.xpath(meetings_subject_column)).getText();
		if(meetingText.equals(meetingSubject)) {
			System.out.println("Meeting created");
		}else {
			System.out.println("Issue in meeting creation");
		}
	}
	
	//To use an Examples table to add products
	
	@Given("^Navigate to All -> Products-> Create Product$")
	public void navigate_to_create_product(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(suiteCRM_dashboard_text)));
		driver.findElement(By.xpath(all_link)).click();
		driver.findElement(By.xpath(products_link)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createProduct_button)));
		driver.findElement(By.xpath(createProduct_button)).click();
	}
	
	
	@When("^Retrieve information about the product \"(.*)\",\"(.*)\",\"(.*)\"$")
	public void retrieve_product_information(String prodName,String price, String description) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createProduct_productName)));
		productName= prodName+" "+key;
		driver.findElement(By.xpath(createProduct_productName)).sendKeys(productName);
		driver.findElement(By.xpath(createProduct_price)).sendKeys(price);
		driver.findElement(By.xpath(createProduct_description)).sendKeys(description);
	}
	
	@Then("^Click Save under products$")
	public void click_save_products() {
		List<WebElement> saveButtons = driver.findElements(By.xpath(createProduct_save_buttons));
		for(WebElement saveButton: saveButtons) {
			saveButton.click();
			break;
		}
	}
		
	@And("^Go to the View Products page to see all products listed$")
	public void view_products() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createProduct_module_title_text)));
		driver.findElement(By.xpath(viewProducts)).click();
		waitseconds(2);
		String productNamevalue= driver.findElement(By.xpath(product_name_column_value)).getText();
		if(productNamevalue.equals(productName)) {
			System.out.println("Product "+productName+" created successfully.");
		}else
			System.out.println("Issue in product "+productName+" creation.");	
	}
	
}
