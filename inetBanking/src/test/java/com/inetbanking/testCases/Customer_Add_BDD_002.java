package com.inetbanking.testCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.AllureListener;

import io.cucumber.java.en.*;
import io.qameta.allure.Step;


@Listeners({AllureListener.class})
public class Customer_Add_BDD_002 extends BaseClass {
	LoginPage lp;
	AddCustomerPage cust;
	WebDriver driver;
	String title;

	@Given("manager is on login page")
	public void manager_is_on_login_page() throws MalformedURLException {
		setup();
		driver = super.driver;
		lp = new LoginPage(driver);
		cust = new AddCustomerPage(driver);
		logger.info("URL is open");
	}

	@When("manager enter username and password")
	public void manager_enter_username_and_password() {
		lp.setUserName(username);
		lp.setPassword(password);
		logger.info("Manager enter username and password");
	}

	@And("manager click on login button")
	public void manager_click_on_login_button() {
		lp.clickSubmit();
	}
	
	@Step("Manager Login Successfully!!")
	@Then("manager verify profile page")
	public void manager_verify_profile_page() throws IOException {
		
		title = driver.getTitle();
		if(title.equals("Guru99 Bank Manager HomePage"))
		{
			logger.info("Login into profile page Successful!!");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			logger.info("Login into profile page Failed!!");
			Assert.assertTrue(false);
		}

	}

	@Then("manager press add customer button")
	public void manager_press_add_customer_button() {
		cust.clickAddNewCustomer();
	}

	@And("manager enters user information into it")
	public void manager_enters_user_information_into_it() {
		cust.custName("Sourabh");
		cust.custgender("male");
		cust.custdob("01", "05", "1995");
		cust.custaddress("INDIA");
		cust.custstate("MAH");
		cust.custcity("PUN");
		cust.custpinno("411001");
		cust.custtelephoneno("9876543210");
		String email = randomestring() + "@gmail.com";
		cust.custemailid(email);
		cust.custpassword("abcdef");
		cust.custsubmit();
		logger.info("Manager Added Customer Information!!");
	}

	@Then("manager verify cutomer is added or not")
	public void manager_verify_cutomer_is_added_or_not() throws IOException {
		try {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		// System.out.println(res);

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	@Step("Customer Registered Successful!!")
	@Then("manager click on logout button")
	public void manager_click_on_logout_button() {
		lp.clickLogout();
	}

	@And("maager exit portal")
	public void maager_exit_portal() {
		tearDown();
	}

}
