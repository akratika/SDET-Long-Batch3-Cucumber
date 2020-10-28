package stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testProject.SDET_CucumberTestProject.DriverSetup;
import testProject.SDET_CucumberTestProject.PageObjects_alchemy;

public class CreateUser_alchemy extends PageObjects_alchemy{
	DriverSetup setup= new DriverSetup();
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on alchemy login Page$")
	public void alchemy_login() {
		driver = setup.propertySetup();
		wait= new WebDriverWait(driver, 20);
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
	@When("^User is logged in as \"(.*)\" and \"(.*)\"$")
	public void login_with_admin_credentials(String arg1, String arg2) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user_login']")));
		driver.findElement(By.xpath(username)).sendKeys(arg1);
		driver.findElement(By.xpath(pass)).sendKeys(arg2);
		driver.findElement(By.xpath(login_button)).click();
	}
	
	@Then("^User clicks on \"Users\" on the left hand menu$")
	public void click_users() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(user_menu)));
		driver.findElement(By.xpath(user_menu)).click();
	}
	
	@And("^User clicks on \"Add New\" button$")
	public void click_add_new_button() {
		Random random = new Random();
		int key = random.nextInt(300);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(add_new_button)));
		driver.findElement(By.xpath(add_new_button)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(new_user_firstname)));
		driver.findElement(By.xpath(new_user_username)).sendKeys("Kratika"+key);
		driver.findElement(By.xpath(new_user_email)).sendKeys("cucumberTest"+key+"@test.com");
		driver.findElement(By.xpath(new_user_firstname)).sendKeys("Kratika"+key);
		driver.findElement(By.xpath(new_user_lastname)).sendKeys("test"+key);
		driver.findElement(By.xpath(new_user_website)).sendKeys("www.testcucumber.com");
		driver.findElement(By.xpath(show_password_button)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(new_user_password)));
		driver.findElement(By.xpath(new_user_password)).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(new_user_password)));
		driver.findElement(By.xpath(new_user_password)).sendKeys("pa$$w0rd");
		if(driver.findElement(By.xpath(confirm_weak_password_checkbox)).isDisplayed()) {
			driver.findElement(By.xpath(confirm_weak_password_checkbox)).click();
		}
		driver.findElement(By.xpath(notification_checkbox)).click();
		Select select= new Select(driver.findElement(By.xpath(new_user_role)));
		select.selectByVisibleText("Administrator");
		driver.findElement(By.xpath(add_new_user_button)).click();
		
	}
	
	@And("^Verify that user was created successfully$")
	public void verify_user() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(new_user_message)));
		String message_text = driver.findElement(By.xpath(new_user_message)).getText();
		if(message_text.trim().equals("New user created. Edit user")) {
			System.out.println("New user created successfully.");
		}else
			System.out.println("Issue in user creation or message text didn't match.");
	}
}
