package Main;

import utility.*;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testcase.loginPageCases;
import utility.ExcelUtils;
import utility.Log;

public class mainClass {
	public WebDriver driver;
	
  
  @Test
  public void validUserNameAndInvalidPass() throws FileNotFoundException {
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.validUserNameAndInvalidPass(driver);}
  
  @Test
  public void invalidUserNameAndValidPass(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.invalidUserNameAndValidPass(driver);
  }
  /*
  @Test
  public void validUserNameAndEmptyPass(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.validUserNameAndEmptyPass(driver);
  }
  
  @Test
  public void emptyUserNameAndValidPass(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.emptyUserNameAndValidPass(driver);
  }
  
  @Test
  public void wrongUserNameAndWrongPass(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.wrongUserNameAndWrongPass(driver);
  }
	 
  @Test
  public void emptyUserNameAndEmptyPass(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.emptyUserNameAndEmptyPass(driver);
  }
	
  @Test
  public void validUserNameAndValidPass(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.validUserNameAndValidPass(driver);
  }

  @Test
  public void logout(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.logout(driver);
  }
	
  @Test
  public void clickForgotLink(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.clickForgotLink(driver);
  }
	 
  @Test
  public void provideUserDigitbutNotMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideUserDigitbutNotMobileNumber(driver);
  }

  @Test
  public void provideEmailInUserNamebutNotMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideEmailInUserNamebutNotMobileNumber(driver);
  }

  @Test
  public void provideNumericInUserNamebutNotMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideNumericInUserNamebutNotMobileNumber(driver);
  }

  @Test
  public void provideCorrectUserNameAndWrongMobileNumnber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideCorrectUserNameAndWrongMobileNumnber(driver);
  }

  @Test
  public void provideCorrectUserNamebutNotMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideCorrectUserNamebutNotMobileNumber(driver);
  }

  @Test
  public void provideCorrectUserNameAndCorrectMobileNumbner(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  //loginTestCase1.provideCorrectUserNameAndCorrectMobileNumber(driver);
  }

  @Test
  public void provideEmptyUserNameAndCorrectMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideEmptyUserNameAndCorrectMobileNumber(driver);
  }

  @Test
  public void provideWrongUserNameAndWrongMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideWrongUserNameAndWrongMobileNumber(driver);
  }
	 
  @Test
  public void provideEmptyUserNameAndEmptyMobileNumber(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.provideEmptyUserNameAndEmptyMobileNumber(driver);
  }
  
  @Test
  public void clearUserNameAndPassword(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.clearUserNameAndPassword(driver);
  }
	 
  @Test
  public void CloseForgot(){
	  loginPageCases loginTestCase1 = new loginPageCases();
	  loginTestCase1.CloseForgot(driver);
  }
	  */
	 
	  
  
  @BeforeTest
  public void beforeMethod() {
	 	String service = Constant.service;
		System.setProperty("webdriver.chrome.driver", service);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Driver is opening URL");
		driver.navigate().to(Constant.URL);
		Assert.assertEquals("http://fleetmanagement.astiinfotech.com/","http://fleetmanagement.astiinfotech.com/");
  }
  
  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }
  
}
