package uk.co.reisinger.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format = {"json:target/cucumber-report.json", "html:target/cucumber-report"})
public class RunCukesTest extends AbstractTestNGCucumberTests {
}
