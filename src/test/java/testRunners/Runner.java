package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile/Customer.feature", dryRun = false,  
glue ="StepDefinations"
		)
public class Runner {

}
