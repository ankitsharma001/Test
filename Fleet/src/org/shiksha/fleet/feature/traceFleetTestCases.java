package org.shiksha.fleet.feature;

import junit.framework.Assert;

import org.shiksha.fleet.pom.*;
import org.shiksha.fleet.Main.testBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.shiksha.fleet.utility.ExcelUtils;
import org.shiksha.fleet.utility.Log;

public class traceFleetTestCases extends testBase {

	@Test(priority = 27, description = "Verify Trace Fleet Page is opened or not")
	public static void checkTraceFleetPage() {
		traceFleetPage tp = new traceFleetPage();
		tp.checkTraceFleetPage(driver);
	}

	@Test(priority = 28, description = "Verify Trace Field Table Details")
	public static void checkFiledDetails() {
		traceFleetPage tp = new traceFleetPage();
		tp.checkTripStartedText(driver);
		tp.checkTripstartTableDetails(driver);
	}
}
