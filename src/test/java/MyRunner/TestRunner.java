package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
	features = ".//src/test/resources/Features",
	glue = "stepsDefination",
	monochrome = true,
	dryRun = false,
	plugin = {"pretty", "html:htmlReports.html"}
//	plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty.html"}
			)

//-----------------------------------------------------
	// Or we can use below code
//@RunWith(Cucumber.class)
//	@CucumberOptions(
//	features = "classpath:Features",
//	glue = "stepDefinations",
//	monochrome = true,
//	dryRun = false
//		)

public class TestRunner {

}
