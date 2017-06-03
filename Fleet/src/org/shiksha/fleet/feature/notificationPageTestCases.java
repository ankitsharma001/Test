package org.shiksha.fleet.feature;

import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.pom.notificationPage;
import org.shiksha.fleet.pom.traceFleetPage;
import org.shiksha.fleet.utility.ExcelUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class notificationPageTestCases extends testBase {
	
	
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
	
	@Test(priority = 29, description = "Verify Notification Page Fields")
	public static void verifyNotificationPageDetails() throws Exception {
		notificationPage np = new notificationPage();
		np.clickNotification(driver);
		testBase.getscreenshot("jp.png");
		np.clickTodaysNotification(driver);
		np.clickAllNotification(driver);
		
	}
	
}
