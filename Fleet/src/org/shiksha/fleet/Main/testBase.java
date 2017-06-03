package org.shiksha.fleet.Main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.sql.Time;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
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
		 String service = Constant.service;
		 System.setProperty("webdriver.chrome.driver", service); 
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 Log.info("Driver is opening URL"); driver.navigate().to(Constant.URL);
		 Assert.assertEquals("http://fleetmanagement.astiinfotech.com/",
		 "http://fleetmanagement.astiinfotech.com/");
		 
	}

	@AfterSuite
	public static void afterMethod() {
		driver.quit();
	}

	public static void getscreenshot(String filename) throws Exception {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
           FileUtils.copyFile(scrFile, new File("C:\\Users\\admin\\git\\Fleet Management\\Fleet\\TestOutput\\"+filename));
	}
	
	
	
	
	
	
	
}
