package testProject.SDET_CucumberTestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup {
	public static WebDriver driver;
	
	public WebDriver propertySetup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\KratikaAgarwal\\AppiumTest\\SDET_CucumberTestProject\\BrowserFiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		return driver;
	}
	
	public void waitseconds(int sec) throws InterruptedException{
		
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
