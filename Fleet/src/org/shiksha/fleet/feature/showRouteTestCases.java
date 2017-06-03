package org.shiksha.fleet.feature;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.pom.routesAddRoute;
import org.shiksha.fleet.pom.showRoute;
import org.shiksha.fleet.utility.ExcelUtils;
import org.shiksha.fleet.utility.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class showRouteTestCases extends testBase{
	
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
	@Test(priority = 46, description = "Show Route Test cases")
	public void verifyAddShowRoute() throws InterruptedException{
		String str = null;//routesAddRoute.handleAlert(driver);
		showRoute srObject = new showRoute();
		srObject.clickOnRoute(driver);
		srObject.checkRouteDropDownList(driver);
		srObject.verifyRoutePageEmptyOrNot(driver);
		srObject.clickOnRouteAssending(driver);
		srObject.clickOnSourceAddress(driver);
		srObject.clickOnDestinatioAddress(driver);
		srObject.typeSerachBox(driver);
		srObject.clickOnEdit(driver);
		routesAddRoute.sendValueToRouteName(driver, "Route1122");
		routesAddRoute.preViewRoute(driver);
		routesAddRoute.saveRoute(driver);
		str = loginPage.AlertWindow(driver);
		Assert.assertEquals(str, "Route Updated successfully...");
		srObject.typeSerachBox(driver);
		srObject.clickOnDelete(driver);
		str = loginPage.AlertWindowYesDeleteIt(driver);
		Assert.assertEquals(str, "Are you sure to delete this route? All the schedules associated with this route will be deleted..");
		str=null;
		String str1 = loginPage.AlertWindow(driver);
		Assert.assertEquals(str1, "Route deleted successfully...");
	}
}
