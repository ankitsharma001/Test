package org.shiksha.fleet.pom;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.pom.*;
import org.shiksha.fleet.utility.Log;


public class notificationPage extends HomePage{

	private static final By dashboard = By.xpath(".//*[@href='#' and contains(text(),'Home')]/following-sibling::ul[1]/li[4]/a");
	private static final By todayRadio = By.xpath(".//*[@id='today' and @type='radio']");
	private static final By allRadio = By.xpath(".//*[@id='all' and @type='radio']");
	private static final By noNotification = By.xpath(".//*[@id='emptynotifications']");
	private static final By notification = By.xpath(".//*[@href='#' and contains(text(),'Home')]/following-sibling::ul[1]/li[4]/a");
		
	public void clickTodaysNotification(WebDriver driver){
		boolean buttonRadioStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noNotification));
		String Notification = driver.findElement(noNotification).getText();
		if(Notification.equalsIgnoreCase("No Notifications Available...")){
			Log.info("No Notification on Todays Notification");
		}
		else{
			wait.until(ExpectedConditions.visibilityOfElementLocated(todayRadio));
			driver.findElement(todayRadio).click();
			buttonRadioStatus = driver.findElement(todayRadio).isSelected();
			if(buttonRadioStatus){
				Log.info("Todays Radio button is selected ..");
				Log.info("Data is availabl in Today's Notification");
			}
			else
				Log.info("Todays Radio button is not selected ..");
		}
	}
	
	
	public void clickAllNotification(WebDriver driver){
		boolean buttonRadioStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allRadio));
		String Notification = driver.findElement(allRadio).getText();
		if(Notification.equalsIgnoreCase("No Notifications Available...")){
			Log.info("No Notification on All Notification");
		}
		else{
			wait.until(ExpectedConditions.visibilityOfElementLocated(allRadio));
			driver.findElement(allRadio).click();
			buttonRadioStatus = driver.findElement(allRadio).isSelected();
			if(buttonRadioStatus){
				Log.info("All Notification Radio button is selected ..");
				Log.info("Data is availabl in All Notification");
			}
			else
				Log.info("All Notification Radio button is not selected ..");
		}
	}
	
	public void clickNotification(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.home));
		driver.findElement(HomePage.home).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
		driver.findElement(notification).click();
		Log.info(driver.getTitle());
	}
}
