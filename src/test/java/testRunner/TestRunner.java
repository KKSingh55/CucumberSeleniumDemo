package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features//customer.feature",
		glue="stepDefination",
		dryRun = false,
		monochrome=true,
		plugin= {"pretty","html:test-output"},
		tags= {"@smoke"}
		)
public class TestRunner {

}


