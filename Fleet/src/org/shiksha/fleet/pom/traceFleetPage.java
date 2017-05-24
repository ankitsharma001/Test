package org.shiksha.fleet.pom;

import java.util.List;

import junit.framework.Assert;

import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.utility.Log;

public class traceFleetPage {

	private static final By traceFleetText = By.xpath(".//i[@class='fa fa-bus']");
	private static final By traceFleetField = By.xpath(".//*[@id='tbl_on_trip_head']/tr/th");
	private static final By FleetTrace = By.xpath(".//*[@href='#' and contains(text(),'Home')]/following-sibling::ul[1]/li[2]/a");
	private static final By home = By
			.xpath(".//*[@class='dropdown-toggle' and contains(text(),'Home')]");
	
	public void checkTraceFleetPage(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		Log.info("Over mouse on Home Tab ..");
		driver.findElement(home).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(FleetTrace));
		driver.findElement(FleetTrace).click();
		Log.info("Fleet Trace Clicked..");
	}
	
	public void checkTripStartedText(WebDriver driver){
		driver.findElement(traceFleetText).isDisplayed();
	}
	
	public void checkTripstartTableDetails(WebDriver driver){
		List<WebElement> list = driver.findElements(traceFleetField);
		for (WebElement webElement : list) {
			String text = webElement.getText();
			Log.info(text);
		}
		Assert.assertEquals((list.get(0).getText()), "Route Name");
		Assert.assertEquals((list.get(1).getText()), "Driver Name");
	}

}
