package com.inetbanking.testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.AllureListener;

import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Listeners({AllureListener.class})
public class Login_Test_BDD_001 extends BaseClass {
	
	LoginPage lp;
	String title;
	
	
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws MalformedURLException {
	    setup();
	    lp = new LoginPage(driver);
	    logger.info("URL is open");
	}
	@When("user enter username and password")
	public void user_enter_username_and_password() {
		
		lp.setUserName(username);
	    lp.setPassword(password);
	    logger.info("UserName and password is entered");
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    lp.clickSubmit();
	}

	@Then("user is on user profile page")
	public void user_is_on_user_profile_page() {
	    title = driver.getTitle();
	}
	@Step("Verify Customer is login successfully")
	@Then("user verify page")
	public void user_verify_page() {
		if(title.equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Succesfully");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login is failed");
		}
	}

	@And("user press logout button")
	public void user_press_logout_button() {
	    lp.clickLogout();
	    tearDown();
	}

	
}
