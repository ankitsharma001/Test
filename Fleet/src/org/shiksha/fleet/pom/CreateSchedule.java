package org.shiksha.fleet.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.utility.Log;
import org.shiksha.fleet.pom.showRoute;

public class CreateSchedule {

	// Page Object Factory

	private static final By selectRoute = By
			.xpath(".//div[@class='selectize-input items not-full has-options']/input[@placeholder='Select Route']");
	private static final By selectVehicle = By
			.xpath(".//div[@class='selectize-input items not-full has-options']/input[@placeholder='Select Vehicle']");
	private static final By btncreate = By.xpath(".//*[@id='btnCreate']");
	private static final By selectRouteDropDownList = By.xpath(".//*[@class='selectize-dropdown-content']/div");
	private static final By sendTimeTextBox = By.xpath(".//*[@name='txt_time']");
	private static final By stopName = By.xpath(".//*[@id='heading']/th[1]");
	private static final By stopAddress = By.xpath(".//*[@id='heading']/th[2]");
	private static final By scheduleTime = By.xpath(".//*[@id='heading']/th[3]");
	static String timeValue = "1010";

	
	//Method Factory
	
	public void clickOnCreateScheduleRoute(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(showRoute.route));
		driver.findElement(showRoute.route).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(showRoute.routeDropDwon));
		List<WebElement> list = driver.findElements(showRoute.routeDropDwon);
		for (WebElement webElement : list) {
			String text = webElement.getText();
			Log.info(text);
			if (text.equals("Create Schedule")){
				webElement.click();
				Log.info("Create Schedule Clicked..");
				break;
			}
		}
	}
	
	public void clickOnVerifyCreateSchedulePageTable(WebDriver driver){
		boolean status = driver.findElement(stopName).isDisplayed();
		if(status){
			Log.info("Stop Name Column is available");
			status = driver.findElement(stopAddress).isDisplayed();
				if(status){
					Log.info("Stop Address Column is available");
					status = driver.findElement(scheduleTime).isDisplayed();
					if(status){
						Log.info("Schedule Time Column is available");
					}
					else
						Log.error("Schedule Time Column is not available");
				}
				else
					Log.error("Stop Address Column is not available");
		}
		else
			Log.error("Stop Name Column is not available");
		
	}
	
	public void selectValuefromSelectRouteDropDownlist(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectRoute));
		driver.findElement(selectRoute).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectRouteDropDownList));
		List<WebElement> list = driver.findElements(selectRouteDropDownList);
		System.out.println("Select Route Drop Down List size : "+list.size());
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if(text.equals("R12")){
				Log.info("R12 is selected...");
				webElement.click();
				break;
			}
		}
	}
	
	public void selectValuefromSelectVehicleDropDownlist(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectVehicle));
		driver.findElement(selectVehicle).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectRouteDropDownList));
		List<WebElement> list = driver.findElements(selectRouteDropDownList);
		System.out.println("Select Route Drop Down List size : "+list.size());
		for (WebElement webElement : list){
			String text = webElement.getText();
			if(text.equals("DemoV2")){
				webElement.click();
				Log.info("DemoV2 selected..");
				break;
			}
		}
	}
	
	public void clickOnCreateLink(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btncreate));
		driver.findElement(btncreate).click();
		Log.info("Create Button clicked");
	}
	
	public void sendValueIntoTimeTextBox(WebDriver driver,boolean status){
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sendTimeTextBox));
		if(status){
			List<WebElement> list = driver.findElements(sendTimeTextBox);
			for (WebElement webElement : list) {
				int i = Integer.parseInt(timeValue);
				int var = i + 10;
				timeValue = Integer.toString(var);
				webElement.sendKeys(timeValue);
			}
		}
		else{
			List<WebElement> list = driver.findElements(sendTimeTextBox);
			for (WebElement webElement : list) {
				webElement.sendKeys(timeValue+10);
				break;
			}
		}
	}
}