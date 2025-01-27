package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Loginstore.feature",
		glue="Stepdefinition",
		dryRun=false,
		monochrome=true,
		plugin = {"pretty", "html:target/Cucumber-Reports/reports.html"},
		tags="@sanity"
		
		)

public class Run {

}
