package org.shiksha.fleet.feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.pom.loginPage;
import org.shiksha.fleet.utility.ExcelUtils;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class datePicker extends testBase{
	
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
	public void datePickerdemo() throws InterruptedException{
		driver.navigate().to("http://fleetmanagement.astiinfotech.com/TripDetails/TripDetails");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("txt_from"))).click().build().perform();
		Thread.sleep(2000);
		
		String MonthYear = driver.findElement(By.xpath(".//*[@id='masterBody']/div/div[2]/div[1]/div[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]")).getText();
		System.out.println(MonthYear);
		
		
	}

}