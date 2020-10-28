package stepDefinitions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testProject.SDET_CucumberTestProject.DriverSetup;
import testProject.SDET_CucumberTestProject.PageObjects_alchemy;

public class SearchJob_alchemy extends PageObjects_alchemy{
	DriverSetup setup= new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open browser with Alchemy Jobs site​$")
	public void alchemy_jobs_site() {
		driver = setup.propertySetup();
		wait= new WebDriverWait(driver, 20);
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@When("^User navigate to Jobs page$")
	public void navigates_to_Jobs_page() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobs_link)));
		driver.findElement(By.xpath(jobs_link)).click();
	}
	
	@Then("^Find the Keywords search input field and Type in keywords to search for jobs and change the Job type$")
	public void keyword_search() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(keyword_text)));
		driver.findElement(By.xpath(keyword_text)).clear();
		driver.findElement(By.xpath(keyword_text)).sendKeys("Automation Tester");
		driver.findElement(By.xpath(search_jobs_button)).click();
	}
	
	@And("^Find the filter using XPath and filter job type to show only “Full Time” jobs$")
	public void add_filter_full_time() {
		driver.findElement(By.xpath(freelance_checkbox)).click();
		driver.findElement(By.xpath(internship_checkbox)).click();
		driver.findElement(By.xpath(partTime_checkbox)).click();
		driver.findElement(By.xpath(temporary_checkbox)).click();
	}
	
	@And("^Find a job listing using XPath and it to see job details$")
	public void verify_user() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(position_list)));
		List<WebElement> position = driver.findElements(By.xpath(position_list));
		for(WebElement pos:position) {
			String pos_text = pos.getText().trim();
			if(pos_text.equals("Automation Tester 01")) {
				pos.click();
				break;
			}
		}
	}
	
	@And("^Find the title of the job listing using XPath and print it to the console$")
	public void find_title_and_print_to_console() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(job_headline)));
		System.out.println(driver.getTitle());
	}
	
	@And("^Find and Click on the “Apply for job” button$")
	public void click_apply_for_job() {
		driver.findElement(By.xpath(applyForJob_button)).click();
	}
	
}
