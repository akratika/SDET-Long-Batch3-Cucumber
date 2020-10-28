package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import testProject.SDET_CucumberTestProject.DriverSetup;
import testProject.SDET_CucumberTestProject.DriverSetup;

public class GoogleSearchSteps{
	DriverSetup setup = new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
	
		
	@Given("^User is on Google Home Page$")
	public void user_on_google_homepage(){
		driver = setup.propertySetup();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.google.com");
		
	}
	
	@When("^User types in Cheese and hits ENTER$")
	public void user_types_cheese_enter() {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
	}
	
	@Then("^Show how many search results were shown$")
	public void show_search_results() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));
		String resultsText = driver.findElement(By.id("result-stats")).getText();
		System.out.println(resultsText);
	}
	
	
}