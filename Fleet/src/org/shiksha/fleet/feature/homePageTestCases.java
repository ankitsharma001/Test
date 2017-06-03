package org.shiksha.fleet.feature;

import junit.framework.Assert;

import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.HomePage;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.utility.ExcelUtils;
import org.shiksha.fleet.utility.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homePageTestCases extends testBase {

	@BeforeClass
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

	@Test(priority = 20, description = "Fetch and display the contents from Home Drop Down List")
	public void verifySizeHomeDropDownMenu() {
		HomePage hpobject = new HomePage();
		hpobject.clickHome(driver);
		String[] HomeDropDown = hpobject.getHomeDropDownDetails(driver);
		Assert.assertEquals(5, HomeDropDown.length);
		Assert.assertEquals("DashBoard", HomeDropDown[0]);
		Assert.assertEquals("Trace Fleet", HomeDropDown[1]);
		Assert.assertEquals("Trip Details", HomeDropDown[2]);
		Assert.assertEquals("Notifications", HomeDropDown[3]);
		Assert.assertEquals("Feedback / Complain / Request", HomeDropDown[4]);
		Log.info("Drop Down List Contains expected Element");
		Log.info(HomeDropDown[0]);
		Log.info(HomeDropDown[1]);
		Log.info(HomeDropDown[2]);
		Log.info(HomeDropDown[3]);
	}

	@Test(priority = 21, description = "Click on DashBoard")
	public void clickDashboard() {
		HomePage hpobject = new HomePage();
		boolean status = hpobject.clickDashboard(driver);
		Assert.assertEquals("Dash Board is not clicked", true, status);
	}

	@Test(priority = 22, description = "Verify Total Employee Repport on DashBoard Page")
	public void verifyTotalEmpReport() {
		HomePage hpobject = new HomePage();
		String TEmpCount = hpobject.verifyTotalEployeeReport(driver);
		Log.info("Total Employee : "+TEmpCount);
	}

	@Test(priority = 23, description = "Verify Female Employee Repport on DashBoard Page")
	public void verifyFemaleTotalEmpReport() {
		HomePage hpobject = new HomePage();
		String TFCount = hpobject.verifyTotalFemaleEmployeeReport(driver);
		Log.info("Female Employee : "+TFCount);
	}

	@Test(priority = 24, description = "Verify Bus Repport on DashBoard Page")
	public void verifyBusReport() {
		HomePage hpobject = new HomePage();
		String BusCount = hpobject.VerifyBusReportReport(driver);
		Log.info("Bus Count : "+BusCount);
	}

	@Test(priority = 25, description = "Verify Shift Summary Report on DashBoard Page")
	public void verifyShiftSummeryReport() {
		HomePage hpobject = new HomePage();
		Boolean shiftReportStatus = hpobject.checkShiftSummaryReport(driver);
		Log.info("Summery Report available Status : " + shiftReportStatus);
	}

	@Test(priority = 26, description = "Verify Schedule Summary Report on DashBoard Page")
	public void verifyScheduleSummeryReport() {
		HomePage hpobject = new HomePage();
		Boolean scheduleReportStatus = hpobject.checkScheduleSummary(driver);
		Log.info("Schedule Summery Report available Status : " + scheduleReportStatus);
	}

}
