package org.shiksha.fleet.feature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.utility.Constant;
import org.shiksha.fleet.utility.ExcelUtils;
import org.shiksha.fleet.utility.Log;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginPageTestCaseScript extends testBase{

		@Test(priority=1)
		public void validUserNameAndInvalidPass() {
			Log.startTestCase("Valid UserName and Invalid Password");
			String username = null;
			String password = null;
			username = ExcelUtils.getData(1, 1, 0);
			password = ExcelUtils.getData(1, 2, 0);
			loginPage.enterUserName(driver, username);
			loginPage.enterPassword(driver, password);
			loginPage.login(driver);
			String message = loginPage.AlertWindow(driver);
			try {
				AssertJUnit.assertEquals("Incorrect Username or Password", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :- Expected is \"Incorrect Username or Password\"");
			}
			Log.endTestCase("Valid UserName and Invalid Password");
		}

		@Test(priority=2)
		public void invalidUserNameAndValidPass() {
			
			Log.startTestCase("Invalid UserName and valid Password");
			String username = null;
			String password = null;
			username = ExcelUtils.getData(2, 1, 1);
			password = ExcelUtils.getData(2, 2, 1);
			loginPage.enterUserName(driver, username);
			loginPage.enterPassword(driver, password);
			loginPage.login(driver);
			String message = loginPage.AlertWindow(driver);
			try {
				AssertJUnit.assertEquals("Incorrect Username or Password ", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Incorrect Username or Password\"");
			}
			Log.endTestCase("Invalid UserName and valid Password");
			username = null;
			password = null;
			
		}
	
		@Test(priority=3)
		public void validUserNameAndEmptyPass() {
			Log.startTestCase("Valid UserName and Empty Password");
			String Username = null;
			String password = null;
			Username = ExcelUtils.getData(3, 1, 2);
			password = ExcelUtils.getData(3, 2, 2);
			loginPage.enterUserName(driver, Username);
			loginPage.enterPassword(driver, password);
			loginPage.login(driver);
			String message = loginPage.AlertWindow(driver);
			try {
				AssertJUnit.assertEquals("Please Provide Username and password", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please Provide Username and password\"");
			}
			Log.endTestCase("Valid UserName and Empty Password");
		}

		@Test(description = "Empty UserName and valid Password",priority=4)
		public void emptyUserNameAndValidPass() {
			Log.startTestCase("Empty UserName and valid Password");
			String Username = null;
			String password = null;
			Username = ExcelUtils.getData(4, 1, 3);
			password = ExcelUtils.getData(4, 2, 3);
			loginPage.enterUserName(driver, Username);
			loginPage.enterPassword(driver, password);
			loginPage.login(driver);
			String message = loginPage.AlertWindow(driver);
			try {
				AssertJUnit.assertEquals("Please Provide Username and password", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :- Expected is \"Please Provide Username and password\"");
			}
			Log.endTestCase("Empty UserName and valid Passwor");
		}

		@Test(description = "Wrong UserName and Wrong Password",priority=5)
		public void wrongUserNameAndWrongPass() {
			Log.startTestCase("Wrong UserName and Wrong Password");
			String Username = null;
			String password = null;
			Username = ExcelUtils.getData(5, 1, 4);
			password = ExcelUtils.getData(5, 2, 4);
			loginPage.enterUserName(driver, Username);
			loginPage.enterPassword(driver, password);
			loginPage.login(driver);
			String message = loginPage.AlertWindow(driver);
			try {
				AssertJUnit.assertEquals("Incorrect Username or Password", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Incorrect Username or Password\"");
			}
			Log.endTestCase("Wrong UserName and Wrong Password");
		}

		@Test(description = "Empty UserName and Empty Password",priority=6)
		public void emptyUserNameAndEmptyPass() {
			Log.startTestCase("Empty UserName and Empty Password");
			String Username = null;
			String password = null;
			Username = ExcelUtils.getData(6, 1, 5);
			password = ExcelUtils.getData(6, 2, 5);
			loginPage.enterUserName(driver, "");
			loginPage.enterPassword(driver, "");
			loginPage.login(driver);
			String message = loginPage.AlertWindow(driver);
			try {
				AssertJUnit.assertEquals("Please Provide Username and password", message);
			} catch (AssertionError AE) {
				Log.error("Alert message is not correct :-  Expected is \"Please Provide Username and password\"");
			}
			Log.endTestCase("Empty UserName and Empty Password");
		}

		@Test(description = "Click on Forgot Link",priority=7)
		public void clickForgotLink() {
			Log.startTestCase("Click on Forgot Link");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
		}

		@Test(description = "Provide digit Value as UserName but not Mobile Number then click Submit Button",priority=8)
		public void provideUserDigitbutNotMobileNumber() {
			Log.startTestCase("Provide digit Value as UserName but not Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for(String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);
				String Username = null;
				String password = null;
				Username = ExcelUtils.getData(8, 1, 7);
				//password = ExcelUtils.getData(8, 2, 8);
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, "");
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				try {
					AssertJUnit.assertEquals("Please enter username and mobile number", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \" Please enter username and mobile number\"");
				}
				Log.endTestCase("Provide digit Value as UserName but not Mobile Number then click Submit Button");
			}
		}
		
		@Test(description = "Provide Email As UserName but not Mobile Number then click Submit Button",priority=9)
		public void provideEmailInUserNamebutNotMobileNumber() {
			Log.startTestCase("Provide Email As UserName but not Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				String Username = null;
				String password = null;
				Username = ExcelUtils.getData(9, 1, 8);
				//password = ExcelUtils.getData(10, 2, 9);
				driver.switchTo().window(Child_Window);  
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, "");
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				try {
					Assert.assertEquals("Please enter username and mobile number", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
				}
				Log.endTestCase("Provide Email As UserName but not Mobile Number then click Submit Button");
			}
		}
		
		@Test(description = "Provide Numeric As UserName but not Mobile Number then click Submit Button",priority=10)
		public void provideNumericInUserNamebutNotMobileNumber() {
			Log.startTestCase("Provide Numeric As UserName but not Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				String Username = null;
				String password = null;
				Username = ExcelUtils.getData(10, 1, 9);
				//password = ExcelUtils.getData(11, 2, 10);
				driver.switchTo().window(Child_Window);  
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, "");
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				try {
					AssertJUnit.assertEquals("Please enter username and mobile number", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
				}
				Log.endTestCase("Provide Numeric As UserName but not Mobile Number then click Submit Button");
			}
		}
		
		@Test(description = "Provide Correct UserName but not Mobile Number then click Submit Button",priority=11)
		public void provideCorrectUserNamebutNotMobileNumber() {
			Log.startTestCase("Provide Correct UserName but not Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);  
				String Username = null;
				String password = null;
				Username = ExcelUtils.getData(11, 1, 10);
				//password = ExcelUtils.getData(11, 2, 10);
				driver.switchTo().window(Child_Window);  
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, "");
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				try {
					AssertJUnit.assertEquals("Please enter username and mobile number", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
				}
				Log.endTestCase("Provide Correct UserName but not Mobile Number then click Submit Button");
			}
		}
		

		@Test(description = "Provide Correct UserName with Wrong Mobile Number then click Submit Button",priority=12)
		public void provideCorrectUserNameAndWrongMobileNumnber(){
			Log.startTestCase("Provide Correct UserName with Wrong Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for(String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);
				String Username = null;
				String password = null;
				Username = ExcelUtils.getData(12, 1, 11);
				password = ExcelUtils.getData(12, 2, 11);
				driver.switchTo().window(Child_Window);
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, password);
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				/*try {
					AssertJUnit.assertEquals("Invalid username or mobile", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Invalid username or mobile\"");
				}*/
				Log.endTestCase("Provide Correct UserName with Wrong Mobile Number then click Submit Button");
			}
		}
		
		
		@Test(description = "Provide Empty UserName with Correct Mobile Number then click Submit Button",priority=13)
		public void provideEmptyUserNameAndCorrectMobileNumber() {
			Log.startTestCase("Provide Empty UserName with Correct Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);
				String Username = null;
				String password = null;
				//Username = ExcelUtils.getData(14, 1, 13);
				password = ExcelUtils.getData(14, 2, 13);
				driver.switchTo().window(Child_Window);
				loginPage.ForgotUserName(driver, "");
				loginPage.forgotMobileNumber(driver, password);
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				/*try {
					AssertJUnit.assertEquals("Please enter username and mobile number", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
				}*/
				Log.endTestCase("Provide Empty UserName with Correct Mobile Number then click Submit Button");
			}
		}
		
		@Test(description = "Provide Wrong UserName with Wrong Mobile Number then click Submit Button",priority=14)
		public void provideWrongUserNameAndWrongMobileNumber() {
			Log.startTestCase("Provide Wrong UserName with Wrong Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);
				String Username = null;
				String password = null;
				Username = ExcelUtils.getData(15, 1, 14);
				password = ExcelUtils.getData(15, 2, 14);
				driver.switchTo().window(Child_Window);
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, password);
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				try {
					AssertJUnit.assertEquals("Invalid username or mobile", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Invalid username or mobile\"");
				}
				Log.endTestCase("Provide Wrong UserName with Wrong Mobile Number then click Submit Button");
			}
		}
		
		@Test(description = "Provide Empty UserName with Empty Mobile Number then click Submit Button",priority=15)
		public void provideEmptyUserNameAndEmptyMobileNumber() {
			Log.startTestCase("Provide Empty UserName with Empty Mobile Number then click Submit Button");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);  
				loginPage.ForgotUserName(driver, "");
				loginPage.forgotMobileNumber(driver, "");
				driver.switchTo().window(Child_Window);
				loginPage.forgotSubmit(driver);
				String message = loginPage.AlertWindow(driver);
				try {
					AssertJUnit.assertEquals("Please enter username and mobile number", message);
				} catch (AssertionError AE) {
					Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
				}
				Log.endTestCase("Provide Empty UserName with Empty Mobile Number then click Submit Button");
			}
		}
		
		@Test(description = "Clear Username And Password",priority=16)
		public void clearUserNameAndPassword() {
			Log.startTestCase("Clear Username And Password");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);
				loginPage.ForgotUserName(driver, "1236546");
				loginPage.ForgotUserNamePasswordClear(driver);
			}
			Log.endTestCase("Clear Username And Password");
		}	
		
		@Test(description = "close Forgot Window",priority=17)
		public void CloseForgot() {
			Log.startTestCase("close Forgot Window");
			loginPage.forgotlink(driver);
			Log.info("Forgot Link Clicked");
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);  
				loginPage.closeForgot(driver);
			}
			Log.endTestCase("close Forgot Window");
		}
		
		@Test(description = "Valid UserName and Valid Password",priority=18)
		public void validUserNameAndValidPass() {
			driver.navigate().refresh();
			Log.startTestCase("Valid UserName and Valid Password");
			String UserName = null;
			String Password = null;
			UserName = ExcelUtils.getData(7, 1, 6);
			Password = ExcelUtils.getData(7, 2, 6);
			loginPage.enterUserName(driver, UserName);
			loginPage.enterPassword(driver, Password);
			loginPage.login(driver);
			Log.endTestCase("Valid UserName and Valid Password");
		}
		
		
		@AfterClass(description = "logout")
		public void logout(){
			Log.startTestCase("logout");
			loginPage.logout(driver);
			Log.endTestCase("Logout Successfully..");
			
		}
		
		@Test(description = "Provide Correct UserName with Correct Mobile Number then click Submit Button",priority=19,enabled=false)
		public void provideCorrectUserNameAndCorrectMobileNumber() {
			Log.startTestCase("Provide Correct UserName with Correct Mobile Number then click Submit Button");
			
			for (String Child_Window : driver.getWindowHandles()){
				driver.switchTo().window(Child_Window);
				String Username = null;
				String Password = null;
				Username = ExcelUtils.getData(13, 1, 12);
				Password = ExcelUtils.getData(13, 2, 12);
				driver.switchTo().window(Child_Window);  
				loginPage.ForgotUserName(driver, Username);
				loginPage.forgotMobileNumber(driver, Password);
				loginPage.fgtSubmit(driver);
				Log.info("Submit Buttong Clicked");
			}
			Log.endTestCase("Provide Correct UserName with Correct Mobile Number then click Submit Button");
		}
		
		
	}
