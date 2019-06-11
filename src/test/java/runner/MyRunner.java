package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helper.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinations" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","junit:target/cucumber-results.xml",
		"json:target/cucumber-reports/cucumber.json" }, monochrome = true)

public class MyRunner {
	@AfterClass
	public static void writeExtentReport() {
		System.out.println("-----------Report---------------");
		ConfigFileReader c = new ConfigFileReader();
		Reporter.loadXMLConfig(new File(c.getReportConfigPath()));
	}
}
