package org.shiksha.fleet.pom;

import java.util.List;
import org.shiksha.fleet.pom.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shiksha.fleet.Main.testBase;
import org.shiksha.fleet.utility.ExcelUtils;
import org.shiksha.fleet.utility.Log;

public class routesAddRoute {

	private static final By RouteDropDown = By
			.xpath(".//*[@class='dropdown-toggle' and contains(text(),'Routes')]");
	private static final By AddRoute = By
			.xpath(".//*[@href='#' and contains(text(),'Routes')]/following-sibling::ul[1]/li[1]/a");
	private static final By routeName = By.xpath(".//*[@id='txtName']");

	private static final By checkShuttle = By.xpath(".//*[@id='chckShuttle']");
	private static final By From = By
			.xpath(".//*[@id='the-basics']/div/div[2]/div/div");
	private static final By fromclick = By
			.xpath(".//*[@id='the-basics']/div/div[1]");
	private static final By Toclick = By
			.xpath(".//*[@id='routeForm']/div[4]/div/div/div[1]");
	private static final By To = By
			.xpath(".//*[@id='routeForm']/div[4]/div/div/div[2]/div/div");
	private static final By StoppageBtn = By.xpath(".//a[@class='pull-right']");
	private static final By Stoppage = By
			.xpath(".//*[@id='extraStoppages']/div/div/div/div[2]/div/div");
	private static final By btnPreview = By.xpath(".//*[@id='btnCreate']");
	private static final By btnSave = By.xpath(".//*[@id='btnSave']");
	private static final By Map = By.xpath(".//*[@class='col-md-7']");
	private static final By deleteStoppage = By
			.xpath(".//*[@class='col-sm-1 col-xs-1 control-label text-danger']");
	private static final By clickStoppageDropDown = By
			.xpath(".//*[@id='extraStoppages']/div/div/div/div[1]");

	public void clickDeleteStoppage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(deleteStoppage));
		driver.findElement(deleteStoppage).click();
		Log.info("Delete Stoppage Clicked");
	}

	public void clickRouteAddRoute(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RouteDropDown));
		driver.findElement(RouteDropDown).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddRoute));
		driver.findElement(AddRoute).click();
		Log.info(driver.getTitle());
	}

	public static void sendValueToRouteName(WebDriver driver, String value) {
		String RouteName = value;
		// RouteName = ExcelUtils.getData(20, 1, 19);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(routeName));
		driver.findElement(routeName).clear();
		driver.findElement(routeName).sendKeys(RouteName);
		Log.info("Route name is enterd :-" + RouteName);
	}

	public void checkisShuttleRoute(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkShuttle));
		driver.findElement(checkShuttle).click();
		boolean status = driver.findElement(checkShuttle).isSelected();
		if (status)
			Log.info("Is select checkbox is clicked");
		else
			Log.info("Is Select Checbox is not clicked");
	}

	public void selectFrom(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromclick));
		driver.findElement(fromclick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(From));
		List<WebElement> list = driver.findElements(From);
		int size = list.size();
		Log.info("From List Size :-" + size);
		String SelectFromString = null;
		SelectFromString = ExcelUtils.getData(22, 1, 21);
		for (WebElement webElement : list) {
			String str = webElement.getText();
			if (str.equals(SelectFromString)) {
				webElement.click();
				Log.info("Dropdownlist Value selected = " + SelectFromString);
				break;
			}
		}
		Log.info("From String Slected ..");
	}

	public void selectFromAndToinOne(WebDriver driver, String FromDropdown,
			String ToDropDown) {
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromclick));
		driver.findElement(fromclick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(From));
		List<WebElement> list = driver.findElements(From);
		int size = list.size();
		Log.info("From List Size :-" + size);
		String SelectFromString = null;
		SelectFromString = FromDropdown;
		for (WebElement webElement : list) {
			String str = webElement.getText();
			if (str.equals(SelectFromString)) {
				webElement.click();
				Log.info("From Dropdownlist Value selected = " + SelectFromString);
				break;
			}
		}
		Log.info("From String Slected ..");
		list = null;

		wait.until(ExpectedConditions.visibilityOfElementLocated(Toclick));
		driver.findElement(Toclick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(To));
		list = driver.findElements(To);
		size = list.size();
		Log.info("To List Size :-" + size);
		String SelectToString = null;
		SelectToString = ToDropDown;
		for (WebElement webElement : list) {
			String str = webElement.getText();
			if (str.equals(SelectToString)) {
				webElement.click();
				Log.info("To Dropdownlist Value selected = " + SelectToString);
				break;
			}
		}
		Log.info("To String Slected ..");

	}

	public void selectTo(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Toclick));
		driver.findElement(Toclick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(To));
		List<WebElement> list = driver.findElements(To);
		int size = list.size();
		Log.info("To List Size :-" + size);
		String SelectToString = null;
		SelectToString = ExcelUtils.getData(23, 1, 22);
		System.out.println("Checking String .." + SelectToString);
		for (WebElement webElement : list) {
			String str = webElement.getText();
			if (str.equals(SelectToString)) {
				webElement.click();
				Log.info("Dropdownlist Value selected = " + SelectToString);
				break;
			}
		}
		testBase.getscreenshot("RadheRadhe.png");
		Log.info("To String Slected ..");
	}

	public void AddStoppage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StoppageBtn));
		driver.findElement(StoppageBtn).click();
		Log.info("Stoppage Addedd ..");
	}

	public void checkStoppage(WebDriver driver, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(clickStoppageDropDown));
			driver.findElement(clickStoppageDropDown).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Stoppage));
			List<WebElement> list = driver.findElements(Stoppage);
			int size = list.size();
			Log.info("Stoppage List Size :-" + size);
			String SelectStoppageString = value;
			for (WebElement webElement : list) {
				String str = webElement.getText();
				if (str.equals(SelectStoppageString)) {
					webElement.click();
					Log.info("Stoppage Value selected = "
							+ SelectStoppageString);
					break;
				}
			}
			Log.info("Stoppage String Slected ..");
		} catch (Exception e) {
			Log.error("Stopppage DropDown list is not available :" + e);
		}
	}

	public static void preViewRoute(WebDriver driver)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnPreview));
		Thread.sleep(8000);
		driver.findElement(btnPreview).click();
		Log.info("Preview button Clicked.");
		// Log.info("Route is showing under MAP Taking Screenshot ..");

		// Taking Scrrenshot of route
	}

	public static void saveRoute(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 35);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnPreview));
		boolean previewStatus = driver.findElement(btnPreview).isEnabled();
		if (!previewStatus) {
			boolean status = driver.findElement(btnSave).isEnabled();
			if (status) {
				driver.findElement(btnSave).click();
				Log.info("Button Save Clicked Succesffully");
			} else
				Log.error("button is not enable ..");
		} else {
			Log.error("Preview Button is not disable..");
		}
	}

	public static String handleAlert(WebDriver driver)
			throws InterruptedException {
		String alertText = null;
		alertText = driver.findElement(loginPage.AlertText).getText();
		String Parent_Window = driver.getWindowHandle();
		for (String Child_Window : driver.getWindowHandles()) {
			driver.switchTo().window(Child_Window);
			driver.findElement(loginPage.btnOK).click();
		}
		Log.info("Handle Alert Message : " + alertText);
		driver.switchTo().window(Parent_Window);

		return alertText;
	}
}
