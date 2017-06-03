package org.shiksha.fleet.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.utility.Log;
import org.shiksha.fleet.pom.routesAddRoute;

import sun.print.resources.serviceui;

public class showRoute {

	// Page Object Factory

	private static final By SearchBox = By
			.xpath(".//input[@class='form-control input-sm']");
	private static final By routeName = By
			.xpath(".//*[contains(text(),'Route Name')]");
	private static final By sourceAddress = By
			.xpath(".//*[contains(text(),'Source Address')]");
	private static final By destinationAddress = By
			.xpath(".//*[contains(text(),'Destination Address')]");
	private static final By action = By
			.xpath(".//*[contains(text(),'Actions')]");
	private static final By finderRoute1 = By
			.xpath(".//*[contains(text(),'Route1')]");
	public static final By route = By
			.xpath(".//*[@class='dropdown-toggle' and contains(text(),'Route')]");
	public static final By routeDropDwon = By
			.xpath(".//*[@href='#' and contains(text(),'Route')]/following-sibling::ul/li");
	public static final By noRouteFound = By.xpath(".//*[@id='error_div']");
	public static final By edit = By.xpath(".//i[@class='fa fa-edit']");
	public static final By delete = By.xpath(".//i[@class='glyphicon glyphicon-trash']");
	
	public static void clickOnRoute(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(route));
		driver.findElement(route).click();
		Log.info("Route Name Clicked");
	}
	
	public void clickOnEdit(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(edit));
		driver.findElement(edit).click();
		Log.info("Edit button Clicked");		
	}

	public void clickOnDelete(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(delete));
		driver.findElement(delete).click();
		Log.info("Delete button Clicked");
	}
	
	
	public void checkRouteDropDownList(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(routeDropDwon));
		
		List<WebElement> list = driver.findElements(routeDropDwon);
		Log.info("Route Tab Drop Down List Size : - " + list.size());
		System.out.println("List Size Route " + list.size());
		for (WebElement webElement : list) {
			String text = webElement.getText();
			Log.info(text);
			if (text.equals("Show Routes")){
				webElement.click();
				break;
			}
		}
	}

	public void verifyRoutePageEmptyOrNot(WebDriver driver) {
		String noRoute = driver.findElement(noRouteFound).getText();
		if (noRoute.equals("No Routes Found")) {
			Log.info("No Route Name Available Yet");
		} else {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(routeName));
			if (driver.findElement(routeName).isDisplayed()) {
				Log.info("Route Name is available");
				if (driver.findElement(sourceAddress).isDisplayed()) {
					Log.info("source Address is available");
					if (driver.findElement(destinationAddress).isDisplayed()) {
						Log.info("destination Address is available");
						if (driver.findElement(action).isDisplayed()) {
							Log.info("action is available");
						} else
							Log.error("Action Column is not available");
					} else
						Log.error("destination Address Column is not available");
				} else
					Log.error("source Address Column is not available");

			} else
				Log.error("route name Column is not available");
		}
	}
	
	public void clickOnRouteAssending(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(routeName));
		driver.findElement(routeName).click();
		Log.info("Route Name Clicked..");
	}
	
	public void clickOnSourceAddress(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sourceAddress));
		driver.findElement(sourceAddress).click();
		Log.info("Source Address Clicked..");
	}
	
	public void clickOnDestinatioAddress(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(destinationAddress));
		driver.findElement(destinationAddress).click();
		Log.info("destination Address Clicked..");
	}
	
	public void typeSerachBox(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox));
		driver.findElement(SearchBox).sendKeys("Route1");
		boolean status = driver.findElement(finderRoute1).isDisplayed();
		if(status)
			Log.info("Route1 Entry is available");
		else
			Log.error("Route1 Entry is not available");
	}
	
	
	
}
