package Main;

import utility.*;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testcase.loginPageCases;
import utility.Log;

public class mainClass {
	public WebDriver driver;
  
  @Test
  public void public_Static_Main() throws FileNotFoundException {
	 loginPageCases loginTestCase = new loginPageCases();
	  
	  loginTestCase.validUserNameAndInvalidPass(driver);
	  loginTestCase.ivalidUserNameAndValidPass(driver);
	  loginTestCase.validUserNameAndEmptyPass(driver);
	  loginTestCase.emptyUserNameAndValidPass(driver);
	  loginTestCase.wrongUserNameAndWrongPass(driver);
	  loginTestCase.emptyUserNameAndEmptyPass(driver);
	  //loginTestCase.validUserNameAndValidPass(driver);
	  loginTestCase.clickForgotLink(driver);
	  loginTestCase.provideUserDigitbutNotMobileNumber(driver);
	  loginTestCase.provideEmailInUserNamebutNotMobileNumber(driver);
	  loginTestCase.provideNumericInUserNamebutNotMobileNumber(driver);
	  loginTestCase.provideCorrectUserNameAndWrongMobileNumnber(driver);
	  loginTestCase.provideCorrectUserNamebutNotMobileNumber(driver);
	  
	  //loginTestCase.provideCorrectUserNameAndCorrectMobileNumner(driver);
	  loginTestCase.provideEmptyUserNameAndCorrectMobileNumber(driver);
	  loginTestCase.provideWrongUserNameAndWrongMobileNumber(driver);
	  loginTestCase.provideEmptyUserNameAndEmptyMobileNumber(driver);
	  loginTestCase.clearUserNameAndPassword(driver);
	  loginTestCase.CloseForgot(driver);
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	 	String service = Constant.service;
		System.setProperty("webdriver.chrome.driver", service);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Driver is opening URL");
		driver.navigate().to(Constant.URL);
		Assert.assertEquals("http://fleetmanagement.astiinfotech.com/","http://fleetmanagement.astiinfotech.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
}
