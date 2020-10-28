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

public class PostJob_featureTable_alchemy extends PageObjects_alchemy{
	DriverSetup setup= new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
	String jobTitleText;
	
	@Given("^Open browser with ​alchemy jobs site​$")
	public void alchemy_jobs_site() {
		driver = setup.propertySetup();
		wait= new WebDriverWait(driver, 20);
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@When("^Go to post a job page$")
	public void post_a_job_page() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobs_link)));
		driver.findElement(By.xpath(post_a_job_link)).click();
	}
	
	@Then("^Read job information \"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\",\"(.*)\" and fill in the details$")
	public void read_job_information_and_fill_details(String usernametext, String password,String jobTitle, String jobType, String jobDescription) {
		Random rand = new Random();
		int key = rand.nextInt(300);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(job_title_text)));
		driver.findElement(By.xpath(sign_in_button)).click();
		driver.findElement(By.xpath(username)).sendKeys(usernametext);
		driver.findElement(By.xpath(pass)).sendKeys(password);
		driver.findElement(By.xpath(login_button)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(job_title_text)));
		jobTitleText= jobTitle+key;
		System.out.println(jobTitleText);
		driver.findElement(By.xpath(job_title_text)).sendKeys(jobTitleText);
		Select select = new Select(driver.findElement(By.xpath(job_type_ddn)));
		select.selectByVisibleText(jobType);
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.xpath(description_text)).sendKeys(jobDescription);
		driver.switchTo().defaultContent();
		
	}
	
	
	  @And("^Click Submit$")
	  public void click_submit() {
	  driver.findElement(By.xpath(preview_button)).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
	  submit_listing_button)));
	  driver.findElement(By.xpath(submit_listing_button)).click();
	  if(driver.findElement(By.xpath(job_submit_message)).isDisplayed()) {
	  System.out.println("Job submitted successfully"); }else
	  System.out.println("Issue in job submission");
	  }
	 
	
	  @And("^Go to the jobs Page$") 
	  public void go_to_jobs_page() {
	  driver.findElement(By.xpath(jobs_link)).click();
	  }
	 
	
	@And("^Confirm Job listing is shown on page$")
	public void find_title_and_print_to_console() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(keyword_text)));

		driver.findElement(By.xpath(keyword_text)).clear();
		driver.findElement(By.xpath(keyword_text)).sendKeys(jobTitleText);
		driver.findElement(By.xpath(search_jobs_button)).click();

		String position_xpath= "//div[@class='position']/h3[text()='"+jobTitleText+"']";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(position_xpath)));
		driver.findElement(By.xpath(position_xpath)).click();
		/*
		 * List<WebElement> position =
		 * driver.findElements(By.xpath("//div[@class='position']/h3")); for(WebElement
		 * pos:position) { String pos_text= pos.getText();
		 * if(pos_text.trim().equals(jobTitle)) { pos.click(); break; } }
		 */
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(applyForJob_button)));
		String desc_text= driver.findElement(By.xpath(description_check)).getText();
		if(desc_text.equals("Automation Tester with Cucumber experience")) {
			System.out.println("Job listing is shown in page");
		}else
			System.out.println("Issue in job listing");
	}
	
	
}
