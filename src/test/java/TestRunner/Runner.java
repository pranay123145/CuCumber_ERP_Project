package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(	features = {"FeatureFiles"},
monochrome = true,
glue = {"StepDefinations"}, 
plugin = {"pretty", "html:target/report/cucumber", "json:target/report/cucumber.json"})
public class Runner
{

}
