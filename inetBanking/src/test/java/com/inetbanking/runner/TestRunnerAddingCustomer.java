package com.inetbanking.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		strict = true,
		features = {"src/test/resources/Features/custAdd.feature"}
		,monochrome = true
		,glue = {"com.inetbanking.testCases"}
		,dryRun = false
		
		)

public class TestRunnerAddingCustomer extends AbstractTestNGCucumberTests{

}
