package cumber.Options;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.lang.annotation.Target;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",plugin = "json:target/jsonReports/cucumber-report.json", glue = {"stepDefinations"})//tags = "@DeletePlaceAPI")
public class TestRunner {
}
