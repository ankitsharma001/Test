package org.shiksha.fleet.feature;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.pom.notificationPage;
import org.shiksha.fleet.pom.routesAddRoute;
import org.shiksha.fleet.utility.ExcelUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.shiksha.fleet.utility.Log;

public class routesAddRouteTestCases extends testBase {

	String Value = null;
/*@BeforeClass
	public void beforeClass() {
		loginPage login = new loginPage();
		String UserName = null;
		String Password = null;
		UserName = ExcelUtils.getData(7, 1, 6);
		Password = ExcelUtils.getData(7, 2, 6);
		loginPage.enterUserName(driver, UserName);
		loginPage.enterPassword(driver, Password);
		loginPage.login(driver);
	}*/
	
 	@Test(priority = 30, description = "Navigate to Routes and click add route")
	public void verifyAddRoutePageDetails() throws Exception {
		routesAddRoute ra = new routesAddRoute();
		ra.clickRouteAddRoute(driver);
	}
 	
	@Test(priority = 31, description = "All Field Should be empty on Add Route Page")
	public void verifyAllFieldEmpty() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Route Name cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 32, description = "Type Route Name and Click on Preview Button ")
	public void typeRouteNameClickPreviewButton() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route123");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Source cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 33, description = "Type Route Name Charcter Value and Click on Preview Button ")
	public void typeRouteNameCharacterClickPreviewButton() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "ABCDEFG");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Source cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 34, description = "Type Route Name Numeric Value and Click on Preview Button ")
	public void typeRouteNameNumericClickPreviewButton() throws Exception {
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "123456789");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Source cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 35, description = "Type Route Name Special Value and Click on Preview Button ")
	public void typeRouteNameSpecialClickPreviewButton() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "@#$%^&");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Source cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 36, description = "type Route Name and select source from dropdown and click preview")
	public void typeRouteSelectDropDownClickPreview() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFrom(driver);
		obj.preViewRoute(driver);
		String message = loginPage.AlertWindow(driver);
		try {
			assertEquals(message, "Destination cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 37, description = "type Route Name and select destination from dropdown and click preview")
	public void typeRouteSelectDestinationDropDownClickPreview() throws Exception{
		routesAddRoute obj = new routesAddRoute();
		driver.navigate().refresh();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectTo(driver);
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Source cannot be empty");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 38, description = "type Route Name and select destination from dropdown and click preview")
	public void typeRouteNameSourceDropDownAndClickPreview() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"SJR Verity","Jigani");
		obj.preViewRoute(driver);
		String message = loginPage.AlertWindow(driver);
		try {
			assertEquals(message,"Either Source or Destination should be company stop");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 39, description = "type Route Name and select destination from dropdown and click preview")
	public void VerifyOneStopAlertMessage() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"DemoCompany","Jigani");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Atleast add one stop...");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 40, description = "Adding Stoppage button After click on Preview button")
	public void verifyStoppageButton() throws InterruptedException{
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"DemoCompany","Jigani");
		obj.AddStoppage(driver);
		obj.preViewRoute(driver);
		String message = loginPage.AlertWindow(driver);
		try {
			assertEquals(message, "Added stops cannot be empty/ remove empty stops");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 41, description = "Verify Source stop is added again in stops...")
	public void verifySourceStoppageSameAlertMessage() throws InterruptedException{
		driver.navigate().refresh();
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"DemoCompany","Jigani");
		obj.AddStoppage(driver);
		obj.checkStoppage(driver, "DemoCompany");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Source stop is added again in stops...");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 42, description = "verify Destination Stoppage Same Alert Message")
	public void verifyDestinationStoppageSameAlertMessage() throws InterruptedException{
		driver.navigate().refresh();
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"Jigani","DemoCompany");
		obj.AddStoppage(driver);
		obj.checkStoppage(driver, "DemoCompany");
		obj.preViewRoute(driver);
		Value = obj.handleAlert(driver);
		try {
			assertEquals(Value, "Destination stop is added again in stops...");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	@Test(priority = 43, description = "verify Map And Take Screenshot")
	public void verifyMapAndTakeScreenshot() throws Exception{
		driver.navigate().refresh();
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"DemoCompany","Jigani");
		obj.AddStoppage(driver);
		obj.checkStoppage(driver, "Marthahalli");
		obj.preViewRoute(driver);
		testBase.getscreenshot("RouteDemoToJiganiWithOneStoppage.png");
		obj.saveRoute(driver);
	}

	@Test(priority = 44, description = "Verify destination stop is added again in stops...")
	public void verifyStoppageDeleteIconClick() throws InterruptedException{
		driver.navigate().refresh();
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"DemoCompany","Jigani");
		obj.AddStoppage(driver);
		obj.checkStoppage(driver, "Marthahalli");
		obj.clickDeleteStoppage(driver);
		String message = loginPage.AlertWindowYesDeleteIt(driver);
		try {
			assertEquals(message, "Sure you want to delete this stop?");
		} catch (Exception e) {
			Log.error("String is not matched .. in alert message");
		}
	}
	
	
	@Test(priority = 45, description = "All Functioanlity into once testcases in Add route")
	public void verifyAddRoutePageE2E() throws InterruptedException{
		driver.navigate().refresh();
		routesAddRoute obj = new routesAddRoute();
		obj.sendValueToRouteName(driver, "Route1");
		obj.selectFromAndToinOne(driver,"DemoCompany","Manayata Tech Park");
		obj.AddStoppage(driver);
		obj.checkStoppage(driver, "SJR Verity");
		obj.preViewRoute(driver);
		obj.saveRoute(driver);
		String message = loginPage.AlertWindow(driver);
		try {
			assertEquals(message, "Route added successfully...");
		} catch (Exception e) {
			Log.error("Duplicate route name exists...");
		}
	}
}
