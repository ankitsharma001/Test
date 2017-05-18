package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.*;
import pageMethod.loginPage;

public class loginPageCases {
	
	//String Parent_Window=null;
	 
	@Test(description = "Valid UserName and Invalid Password", priority=1)
	public void validUserNameAndInvalidPass(WebDriver driver) {
		Log.startTestCase("Valid UserName and Invalid Password");
		System.out.println("sdflkdsalfds");
		loginPage.enterUserName(driver, "demo");
		loginPage.enterPassword(driver, "1");
		String message = loginPage.clickLogInBtn(driver);
		try {
			Assert.assertEquals("Incorrect Username or Password", message);
		} catch (AssertionError AE) {
			Log.warn("Alert message is not correct :- Expected is \"Incorrect Username or Password\"");
		}
		Log.endTestCase("Valid UserName and Invalid Password");
	}

	@Test(description = "Invalid UserName and valid Password")
	public void ivalidUserNameAndValidPass(WebDriver driver) {
		Log.startTestCase("Invalid UserName and valid Password");
		loginPage.enterUserName(driver, "13");
		loginPage.enterPassword(driver, "demo");
		String message = loginPage.clickLogInBtn(driver);
		try {
			Assert.assertEquals("Incorrect Username or Password", message);
		} catch (AssertionError AE) {
			Log.warn("Alert message is not correct :-  Expected is \"Incorrect Username or Password\"");
		}
		Log.endTestCase("Invalid UserName and valid Password");
	}

	@Test(description = "Valid UserName and Empty Password")
	public void validUserNameAndEmptyPass(WebDriver driver) {
		Log.startTestCase("Valid UserName and Empty Password");
		loginPage.enterUserName(driver, "demo");
		loginPage.enterPassword(driver, "");
		String message = loginPage.clickLogInBtn(driver);
		try {
			Assert.assertEquals("Please Provide Username and password", message);
		} catch (AssertionError AE) {
			Log.warn("Alert message is not correct :-  Expected is \"Please Provide Username and password\"");
		}
		Log.endTestCase("Valid UserName and Empty Password");
	}

	@Test(description = "Empty UserName and valid Password")
	public void emptyUserNameAndValidPass(WebDriver driver) {
		Log.startTestCase("Empty UserName and valid Password");
		loginPage.enterUserName(driver, "");
		loginPage.enterPassword(driver, "demo");
		String message = loginPage.clickLogInBtn(driver);
		try {
			Assert.assertEquals("Please Provide Username and password", message);
		} catch (AssertionError AE) {
			Log.warn("Alert message is not correct :- Expected is \"Please Provide Username and password\"");
		}
		Log.endTestCase("Empty UserName and valid Passwor");
	}

	@Test(description = "Wrong UserName and Wrong Password")
	public void wrongUserNameAndWrongPass(WebDriver driver) {
		Log.startTestCase("Wrong UserName and Wrong Password");
		loginPage.enterUserName(driver, "fdasf");
		loginPage.enterPassword(driver, "dafdsa");
		String message = loginPage.clickLogInBtn(driver);
		try {
			Assert.assertEquals("Incorrect Username or Password", message);
		} catch (AssertionError AE) {
			Log.warn("Alert message is not correct :-  Expected is \"Incorrect Username or Password\"");
		}
		Log.endTestCase("Wrong UserName and Wrong Password");
	}

	@Test(description = "Empty UserName and Empty Password")
	public void emptyUserNameAndEmptyPass(WebDriver driver) {
		Log.startTestCase("Empty UserName and Empty Password");
		loginPage.enterUserName(driver, "");
		loginPage.enterPassword(driver, "");
		String message = loginPage.clickLogInBtn(driver);
		try {
			Assert.assertEquals("Please Provide Username and password", message);
		} catch (AssertionError AE) {
			Log.warn("Alert message is not correct :-  Expected is \"Please Provide Username and password\"");
		}
		Log.endTestCase("Empty UserName and Empty Password");
	}

	@Test(description = "Valid UserName and Valid Password")
	public void validUserNameAndValidPass(WebDriver driver) {
		Log.startTestCase("Valid UserName and Valid Password");
		loginPage.enterUserName(driver, "demo");
		loginPage.enterPassword(driver, "demo");
		loginPage.login(driver);
		Log.endTestCase("Valid UserName and Valid Password");
	}

	@Test(description = "Click on Forgot Link")
	public void clickForgotLink(WebDriver driver) {
		Log.startTestCase("Click on Forgot Link");
		loginPage.forgotlink(driver);
		Log.info("Forgot Link Clicked");
		//Assert.assertEquals("Please Provide Username and password", message);
		// Storing parent window reference into a String Variable
		//Parent_Window = driver.getWindowHandle();
	}

	@Test(description = "Provide digit Value as UserName but not Mobile Number then click Submit Button")
	public void provideUserDigitbutNotMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide UserName but not Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "131234123");
			loginPage.forgotMobileNumber(driver, "");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Please enter username and mobile number", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
			}
			Log.endTestCase("Provide UserName but not Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Provide Email As UserName but not Mobile Number then click Submit Button")
	public void provideEmailInUserNamebutNotMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide UserName but not Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "sunity@gmail.com");
			loginPage.forgotMobileNumber(driver, "");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Please enter username and mobile number", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
			}
			Log.endTestCase("Provide Email As UserName but not Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Provide Numeric As UserName but not Mobile Number then click Submit Button")
	public void provideNumericInUserNamebutNotMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide Numeric As UserName but not Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "Meena123");
			loginPage.forgotMobileNumber(driver, "");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Please enter username and mobile number", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
			}
			Log.endTestCase("Provide Numeric As UserName but not Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Provide Correct UserName but not Mobile Number then click Submit Button")
	public void provideCorrectUserNamebutNotMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide Correct UserName but not Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "demo");
			loginPage.forgotMobileNumber(driver, "");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Please enter username and mobile number", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
			}
			Log.endTestCase("Provide Correct UserName but not Mobile Number then click Submit Button");
		}
	}
	

	@Test(description = "Provide Correct UserName with Wrong Mobile Number then click Submit Button")
	public void provideCorrectUserNameAndWrongMobileNumnber(WebDriver driver) {
		Log.startTestCase("Provide Correct UserName with Wrong Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "demo");
			loginPage.forgotMobileNumber(driver, "7894651235");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Invalid username or mobile", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Invalid username or mobile\"");
			}
			Log.endTestCase("Provide Correct UserName with Wrong Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Provide Correct UserName with Correct Mobile Number then click Submit Button")
	public void provideCorrectUserNameAndCorrectMobileNumner(WebDriver driver) {
		Log.startTestCase("Provide Correct UserName with Correct Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "demo");
			loginPage.forgotMobileNumber(driver, "1324567980");
			loginPage.fgtSubmit(driver);
			Log.info("Submit Buttong Clicked");
		}
		Log.endTestCase("Provide Correct UserName with Correct Mobile Number then click Submit Button");
	}
	
	
	@Test(description = "Provide Empty UserName with Correct Mobile Number then click Submit Button")
	public void provideEmptyUserNameAndCorrectMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide Empty UserName with Correct Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "");
			loginPage.forgotMobileNumber(driver, "7676670809");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Please enter username and mobile number", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
			}
			Log.endTestCase("Provide Empty UserName with Correct Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Provide Wrong UserName with Wrong Mobile Number then click Submit Button")
	public void provideWrongUserNameAndWrongMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide Wrong UserName with Wrong Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "demo123421");
			loginPage.forgotMobileNumber(driver, "767667");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Invalid username or mobile", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Invalid username or mobile\"");
			}
			Log.endTestCase("Provide Wrong UserName with Wrong Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Provide Empty UserName with Empty Mobile Number then click Submit Button")
	public void provideEmptyUserNameAndEmptyMobileNumber(WebDriver driver) {
		Log.startTestCase("Provide Empty UserName with Empty Mobile Number then click Submit Button");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.ForgotUserName(driver, "");
			loginPage.forgotMobileNumber(driver, "");
			String message = loginPage.forgotSubmit(driver);
			try {
				Assert.assertEquals("Please enter username and mobile number", message);
			} catch (AssertionError AE) {
				Log.warn("Alert message is not correct :-  Expected is \"Please enter username and mobile number\"");
			}
			Log.endTestCase("Provide Empty UserName with Empty Mobile Number then click Submit Button");
		}
	}
	
	@Test(description = "Clear Username And Password")
	public void clearUserNameAndPassword(WebDriver driver) {
		Log.startTestCase("Clear Username And Password");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);
			loginPage.ForgotUserName(driver, "1236546");
			loginPage.ForgotUserNamePasswordClear(driver);
		}
		Log.endTestCase("Clear Username And Password");
	}	
	
	@Test(description = "close Forgot Window")
	public void CloseForgot(WebDriver driver) {
		Log.startTestCase("close Forgot Window");
		
		for (String Child_Window : driver.getWindowHandles()){
			driver.switchTo().window(Child_Window);  
			loginPage.closeForgot(driver);
		}
		Log.endTestCase("close Forgot Window");
	}
}