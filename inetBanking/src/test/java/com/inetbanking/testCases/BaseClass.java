package com.inetbanking.testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.*;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public Logger logger;
	//String path = readconfig.getChromePath();
	String baseURL = readconfig.getApplicationURL();
	String username = readconfig.getUsername();
	String password = readconfig.getPassword();
	String br = "chrome";

	//@Parameters("Browser")
	@BeforeTest
	public WebDriver setup() throws MalformedURLException {
		if (br.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			//driver = new ChromeDriver();
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			 System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			 driver = new ChromeDriver();

			/*
			 * ChromeOptions opt = new ChromeOptions(); driver = new RemoteWebDriver(new
			 * URL("http://localhost:4545/wd/hub"), opt);
			 */
		}

		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tdriver.set(driver);

		driver.get(baseURL);
		driver.manage().window().maximize();

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		return getDriver();
	}

	@AfterTest
	public void tearDown() {
		// driver.close();
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

}
