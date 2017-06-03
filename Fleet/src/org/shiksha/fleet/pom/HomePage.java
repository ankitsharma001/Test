package org.shiksha.fleet.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.utility.Log;
import org.testng.annotations.Test;

public class HomePage{

	public static final By home = By
			.xpath(".//*[@class='dropdown-toggle' and contains(text(),'Home')]");
	private static final By homeDropDown = By
			.xpath(".//*[@href='#' and contains(text(),'Home')]/following-sibling::ul[1]/li/a");
	private static final By dashboard = By.xpath(".//*[@href='#' and contains(text(),'Home')]/following-sibling::ul[1]/li[1]/a");
	private static final By totalEmployee=By.xpath(".//*[@id='totalEmp']/div");
	private static final By totalFemale=By.xpath(".//*[@id='totalEmpF']/div");
	private static final By totalBus=By.xpath(".//*[@id='totalEmpM']/div/span");
	private static final By shiftsummary=By.xpath(".//*[@id='chart_shifts']");
	private static final By schedulesummary=By.xpath(".//*[@id='chart_schedules']");
	
	public static void clickHome(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		driver.findElement(home).click();
		Log.info("Clicked on Home");
	}

	public static String[] getHomeDropDownDetails(WebDriver driver) {

		String[] dropContainer = new String[5];
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		Log.info("Fetching Home Drop Down Menu List Item Details..");
		driver.findElement(home).click();
		
		List<WebElement> lists = driver.findElements(homeDropDown);
		
		int size = 0;
		for (int i = 1; i <= lists.size(); i++) {
			HomePage.clickHome(driver);
			WebDriverWait wait1 = new WebDriverWait(driver, 15);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(home));
			driver.findElement(home).click();
			WebElement linkElement = driver
					.findElement(By
							.xpath(".//*[@href='#' and contains(text(),'Home')]/following-sibling::ul/li["
									+ i + "]/a"));
			Log.info(dropContainer[size++]=linkElement.getText());
			
		}
		return dropContainer;
	}
	
	public static boolean clickDashboard(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		driver.findElement(home).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
		driver.findElement(dashboard).click();
		Log.info("Dashboard is clicked");
		return true;
	}
	
	public static String verifyTotalEployeeReport(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalEmployee));
		WebElement totalEmp = driver.findElement(totalEmployee);
		String empCount = totalEmp.getText();
		return empCount;
	}
	
	public static String verifyTotalFemaleEmployeeReport(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalFemale));
		WebElement totalEmp = driver.findElement(totalFemale);
		String FempCount = totalEmp.getText();
		return FempCount;
	}
	
	public static String VerifyBusReportReport(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(totalBus));
		WebElement totalbus = driver.findElement(totalBus);
		String busCount = totalbus.getText();
		return busCount;
	}
	
	public static boolean checkShiftSummaryReport(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(shiftsummary));
		return driver.findElement(shiftsummary).isDisplayed();
	}
	
	public static boolean checkScheduleSummary(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(schedulesummary));
		return driver.findElement(schedulesummary).isDisplayed();
	}
	
	
}