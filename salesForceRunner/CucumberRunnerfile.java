package salesForceRunner;

import io.cucumber.testng.CucumberOptions;
import stepDefinitionsforPages.Preconditions;

@CucumberOptions(features = "src/main/java/salesForceFeatureTestcases", glue = "stepDefinitionsforPages", monochrome = true, publish = true)
public class CucumberRunnerfile extends Preconditions {

}
