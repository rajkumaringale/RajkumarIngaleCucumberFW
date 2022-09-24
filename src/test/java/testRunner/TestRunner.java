package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features//LoginFeature.feature",
	 //	features = {".//Features//Customers.feature",".//Features//LoginFeature.feature"},
	//	features = ".//Features/",
		glue="StepDefinition",
		dryRun = false,     //dryRun = true check for all steps are Mapped with StepDef
		monochrome = true, //output should be displayed in readable format
		tags="@sanity",//scenarios under @sanity tag will be executed
	//	plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
	    plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
		)
public class TestRunner {
	
	

}
