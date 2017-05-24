package org.shiksha.fleet.Main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.shiksha.fleet.utility.Constant;
import org.shiksha.fleet.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

//import testcase.loginPageCases;

public class testBase {

	public static WebDriver driver;

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	private static Logger Log = Logger.getLogger(Log.class.getName());//

	@BeforeSuite
	public static void beforeSuite() throws MalformedURLException {
		
		String baseUrl , nodeUrl;
		baseUrl = "http://fleetmanagement.astiinfotech.com/";
		nodeUrl = "http://192.168.10.21:5568/wd/hub";

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN8_1);

		driver = new RemoteWebDriver(new URL(nodeUrl),capability);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		Log.info("Driver is opening URL");
	}

	@AfterSuite
	public static void afterMethod() {
		driver.quit();
	}

	// Initialize Log4j logsValid UserName and Invalid Password

	public static void startTestCase(String sTestCaseName) {
		Log.info("________________________________________________________________________________________");
		Log.info("****************************************************************************************");
		Log.info("Test case Name -->  " + sTestCaseName + "       ");
		Log.info("****************************************************************************************");
		Log.info("                                                                                        ");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName) {
		Log.info("                                                                                        ");
		Log.info("****************************************************************************************");
		Log.info("End Test Case --->             " + sTestCaseName
				+ "           ");
		Log.info("****************************************************************************************");
		Log.info("                                                                                        ");
		Log.info("________________________________________________________________________________________");
	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

	/*
	 * String service = Constant.service;
	 * 
	 * System.setProperty("webdriver.chrome.driver", service); driver = new
	 * ChromeDriver(); driver.manage().window().maximize();
	 * Log.info("Driver is opening URL"); driver.navigate().to(Constant.URL);
	 * Assert.assertEquals("http://fleetmanagement.astiinfotech.com/",
	 * "http://fleetmanagement.astiinfotech.com/");
	 */
}