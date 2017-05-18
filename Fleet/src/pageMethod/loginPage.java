package pageMethod;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.Log;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class loginPage {
	
	/* Login Page Object Factory
	 * Login Page Factor Object
	 */
	
	private static final By userName = By.xpath(".//*[@id='txt_username']");
	private static final By password=By.id("txt_Password");
	private static final By keepMeSignIn=By.id("chk_RemberMe");
	private static final By loginbtn=By.xpath(".//*[@class='btn' and @type='button']");
	private static final By resetbtn=By.xpath(".//*[@class='btn' and @type='reset']");
	private static final By linkforgot=By.xpath(".//*[contains(text(),'FORGOT PASSWORD ?')]");
	
	//Forgot Password Window Page Factory
	private static final By forgotUserName=By.xpath(".//input[@id='txtuname']");
	private static final By forgotMobileNumber=By.xpath(".//input[@id='txtmobile']");
	private static final By forgotClear=By.xpath(".//*[@value='Clear']");
	private static final By forgotSubmit=By.xpath(".//*[@value='Submit']");
	private static final By forgotClose=By.xpath(".//*[@class='close']");
	private static final By closeforgot=By.xpath(".//*[@class='close']");
	private static final By btnlogout=By.xpath(".//*[contains(text(),'Logout')]");
	private static final By demo=By.xpath(".//*[contains(text(),'demo')]");
	static String Parent_Window=null;
	/*
	 * Page Factory Method
	 * created By Ankit Sharma
	 */
	
	public static void enterUserName(WebDriver driver,String username){
		
		driver.findElement(userName).clear();
		Log.info("Entering Username :"+username);
		driver.findElement(userName).sendKeys(username);
	}
	
	public static void enterPassword(WebDriver driver,String pass){
		driver.findElement(password).clear();
		Log.info("Entering Password: "+pass);
		driver.findElement(password).sendKeys(pass);
	}
	
	public static String clickLogInBtn(WebDriver driver){
		Log.info("Click login Button");
		driver.findElement(loginbtn).click();
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Log.info("Handle Alert Message : "+alertText);
		alert.accept();
		return alertText;
	}
	
	public static void login(WebDriver driver){
		Log.info("click login button");
		driver.findElement(loginbtn).click();
	}
	
	public static void forgotlink(WebDriver driver){
		Log.info("Click on forgot link");
		driver.findElement(linkforgot).click();
		Parent_Window = driver.getWindowHandle();
	}
	
	public static void ForgotUserName(WebDriver driver,String UserName){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotUserName));
		driver.findElement(forgotUserName).clear();
		Log.info("Entering Username in forgot link Window : "+ UserName);
		driver.findElement(forgotUserName).sendKeys(UserName);
	}
	
	public static void forgotMobileNumber(WebDriver driver, String Mobile){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotMobileNumber));
		driver.findElement(forgotMobileNumber).clear();
		Log.info("Entering Mobile Number in forgot link Window : "+Mobile);
		driver.findElement(forgotMobileNumber).sendKeys(Mobile);
	}
	
	public static void forgotPageClear(WebDriver driver){
		Log.info("Clear link Window");
		driver.findElement(forgotClear).clear();
	}
	
	public static String forgotSubmit(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotSubmit));
		Log.info("Click on forgot submit button");
		driver.findElement(forgotSubmit).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Log.info("Handle Alert Window and getting message"+alertText);
		alert.accept();
		return alertText;
	}
	
	public static void fgtSubmit(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotSubmit));
		Log.info("Forgot submit button click");
		driver.findElement(forgotSubmit).click();
		
	}
	
	public static void forgotPageSubmit(WebDriver driver){
		Log.info("Forgot Page submit clicked");
		driver.findElement(forgotSubmit).click();
	}
	
	public static void forgotclose(WebDriver driver){
		Log.info("Forgot button close");
		driver.findElement(forgotClose).click();
	}
	
	public static void ForgotUserNamePasswordClear(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotUserName));
		driver.findElement(forgotUserName).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotMobileNumber));
		driver.findElement(forgotMobileNumber).clear();
		Log.info("Forgot filed cleard ");
	}
	
	public static void closeForgot(WebDriver driver){
		Log.info("Forgot close clicked ");
		driver.findElement(forgotClose).click();
		driver.switchTo().window(Parent_Window);
	}
	public static void logout(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(demo));
		WebElement searchBtn = driver.findElement(demo);
		Actions action = new Actions(driver);
		action.moveToElement(searchBtn).perform();
		driver.findElement(demo).click();;
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnlogout));
		driver.findElement(btnlogout).click();;
	}
}
	
