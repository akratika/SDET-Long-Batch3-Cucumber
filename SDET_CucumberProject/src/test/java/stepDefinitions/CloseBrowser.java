package stepDefinitions;


import cucumber.api.java.en.And;
import testProject.SDET_CucumberTestProject.DriverSetup;

public class CloseBrowser extends DriverSetup{
	@And("^Close the browser$")
	public void close_browser() {
		driver.close();
	}
}
