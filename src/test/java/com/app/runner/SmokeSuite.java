package com.app.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", glue = { "com.framework.webdriver", "com.app.test" }, plugin = { "pretty",
		"html:Reports/AutomationTestReport.html" }, tags = "@Sanity")

public class SmokeSuite {

}
