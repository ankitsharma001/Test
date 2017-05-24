package org.shiksha.fleet.feature;

import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.pom.tripDetailsPage;
import org.shiksha.fleet.utility.ExcelUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.shiksha.fleet.utility.Log;

public class tripDetailsTestCases extends testBase{
	
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
	
	@Test
	public static void tripDetails(){
		tripDetailsPage tp = new tripDetailsPage();
		tp.clicktripDetails(driver);
		tp.verifyTripDetailsPage(driver);
		tp.selectFromYear(driver);
	}
  
}
