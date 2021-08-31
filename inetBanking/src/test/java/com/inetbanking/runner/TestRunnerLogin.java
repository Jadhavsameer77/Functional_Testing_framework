package com.inetbanking.runner;

import org.testng.annotations.Listeners;

import com.inetbanking.utilities.AllureListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		strict = true,
		features = {"src/test/resources/login.feature"}
		,monochrome = true
		,glue = {"com.inetbanking.testCases"}
		,dryRun = false
		
		)

public class TestRunnerLogin extends AbstractTestNGCucumberTests{

	
	
}
