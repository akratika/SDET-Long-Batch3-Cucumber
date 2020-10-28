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
import testProject.SDET_CucumberTestProject.DriverSetup;

public class LoginTestSteps {
	DriverSetup setup = new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
		
	
	@Given("^User is on Login page$")
	public void login_page(){
		driver = setup.propertySetup();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.training-support.net/selenium/login-form");
		
	}
	
	@When("^User enters username and password$")
	public void user_enter_credentials() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='ui button']")).sendKeys("admin");
	}
	
	@Then("^Read the page title and confirmation message$")
	public void show_search_results() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Login Form')]")));
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
	}
		
}
