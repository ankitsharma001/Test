package org.shiksha.fleet.pom;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.utility.Log;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class tripDetailsPage {

	private static final By home = By
			.xpath(".//*[@class='dropdown-toggle' and contains(text(),'Home')]");
	private static final By tripdetails = By
			.xpath(".//a[@href='/TripDetails/TripDetails']");
	private static By fromDate = By.xpath(".//label[contains(text(),'FROM :')]/following-sibling::input");
	private static By selectfromDate = By
			.xpath(".//*[@id='masterBody']/div/div[2]/div[1]/div[1]/div/ul/li[1]/div/div[1]/table/tbody/tr[1]/td[2]");

	public static void clicktripDetails(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		driver.findElement(home).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(tripdetails));
		driver.findElement(tripdetails).click();
		Log.info("trip details is clicked");
	}

	public static void verifyTripDetailsPage(WebDriver driver) {
		String tripDetailsPageTitle = driver.getTitle();
		System.out.println(tripDetailsPageTitle);
		Log.info(tripDetailsPageTitle);
	}

	public static void selectFromYear(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromDate));
		driver.findElement(fromDate).clear();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("txt_from"))).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromDate));
		
	/*	Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement
				(driver.findElement(By.id("txt_from")))
				.sendKeys("20-05-2017");
		seriesOfActions.perform();*/
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('20-05-2017'),driver.findElement(By.id('txt_from'))");
		
		String text = driver.findElement(By.id("txt_from")).getAttribute("value");
		System.out.println("Value = "+text);
		//act.perform();
	}

}
