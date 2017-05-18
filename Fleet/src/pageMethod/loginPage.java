package pageMethod;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
	static String Parent_Window=null;
	/*
	 * Page Factory Method
	 * created By Ankit Sharma
	 */
	
	public static void enterUserName(WebDriver driver,String username){
		
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(username);
	}
	
	public static void enterPassword(WebDriver driver,String pass){
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	
	public static String clickLogInBtn(WebDriver driver){
		driver.findElement(loginbtn).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
	
	public static void login(WebDriver driver){
		driver.findElement(loginbtn).click();
	}
	
	public static void forgotlink(WebDriver driver){
		driver.findElement(linkforgot).click();
		Parent_Window = driver.getWindowHandle();
	}
	
	public static void ForgotUserName(WebDriver driver,String UserName){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotUserName));
		driver.findElement(forgotUserName).clear();
		driver.findElement(forgotUserName).sendKeys(UserName);
	}
	
	public static void forgotMobileNumber(WebDriver driver, String Mobile){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotMobileNumber));
		driver.findElement(forgotMobileNumber).clear();
		driver.findElement(forgotMobileNumber).sendKeys(Mobile);
	}
	
	public static void forgotPageClear(WebDriver driver){
		driver.findElement(forgotClear).clear();
	}
	
	public static String forgotSubmit(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotSubmit));
		driver.findElement(forgotSubmit).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
	
	public static void fgtSubmit(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotSubmit));
		driver.findElement(forgotSubmit).click();
		
	}
	
	public static void forgotPageSubmit(WebDriver driver){
		driver.findElement(forgotSubmit).click();
	}
	
	public static void forgotclose(WebDriver driver){
		driver.findElement(forgotClose).click();
	}
	
	public static void ForgotUserNamePasswordClear(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotUserName));
		driver.findElement(forgotUserName).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotMobileNumber));
		driver.findElement(forgotMobileNumber).clear();
	}
	
	public static void closeForgot(WebDriver driver){
		driver.findElement(forgotClose);
		driver.switchTo().window(Parent_Window);
	}
}
	
