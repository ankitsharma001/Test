package org.shiksha.fleet.feature;

import org.junit.Assert;
import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.CreateSchedule;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.pom.routesAddRoute;
import org.shiksha.fleet.pom.showRoute;
import org.shiksha.fleet.utility.ExcelUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class createScheduleTestCase extends testBase{
  
/*	@BeforeClass
	public void beforeClass() {
		loginPage login = new loginPage();
		String UserName = null;
		String Password = null;
		UserName = ExcelUtils.getData(7, 1, 6);
		Password = ExcelUtils.getData(7, 2, 6);
		loginPage.enterUserName(driver, UserName);
		loginPage.enterPassword(driver, Password);
		loginPage.login(driver);
	}
	
	*/
	@Test(priority = 47, description = "Click on Create Schedule Page")
	public void clickOnCreateSchedulePage() throws InterruptedException{
		CreateSchedule CsObject = new CreateSchedule();
		showRoute.clickOnRoute(driver);
		CsObject.clickOnCreateScheduleRoute(driver);
		CsObject.selectValuefromSelectRouteDropDownlist(driver);
		CsObject.clickOnCreateLink(driver);
		String message = loginPage.AlertWindow(driver);
		Assert.assertEquals(message, "Vehicle must be selected...");
		
		driver.navigate().refresh();
		showRoute.clickOnRoute(driver);
		CsObject.selectValuefromSelectVehicleDropDownlist(driver);
		CsObject.clickOnCreateLink(driver);
		message = loginPage.AlertWindow(driver);
		Assert.assertEquals(message, "Route must be selected...");
		
		driver.navigate().refresh();
		CsObject.selectValuefromSelectRouteDropDownlist(driver);
		CsObject.sendValueIntoTimeTextBox(driver,false);
		CsObject.clickOnCreateLink(driver);
		message = loginPage.AlertWindow(driver);
		Assert.assertEquals(message, "Vehicle must be selected...");
		
		driver.navigate().refresh();
		CsObject.selectValuefromSelectVehicleDropDownlist(driver);
		CsObject.selectValuefromSelectRouteDropDownlist(driver);
		CsObject.sendValueIntoTimeTextBox(driver,false);
		CsObject.clickOnCreateLink(driver);
		message = loginPage.AlertWindow(driver);
		Assert.assertEquals(message, "Please enter the time for all the stops");
		
		//
		driver.navigate().refresh();
		CsObject.selectValuefromSelectVehicleDropDownlist(driver);
		CsObject.selectValuefromSelectRouteDropDownlist(driver);
		CsObject.sendValueIntoTimeTextBox(driver,true);
		CsObject.clickOnCreateLink(driver);
		message = loginPage.AlertWindow(driver);
		Assert.assertEquals(message, "Schedule created successfully...");
		
	}
	
}
