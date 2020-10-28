package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "Features",
	glue = {"stepDefinitions"},
	tags = {"@alchemyJobs_1,@alchemyJobs_2,@alchemyJobs_3,@alchemyJobs_4,@orangeHRM,@suiteCRM"},    
	strict = true

		)

public class ActivitiesRunner {
	
}
