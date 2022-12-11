package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0016_JavaScriptErrorTest extends BaseClass {

	private static String JS_ERROR_TYPEERROR = "TypeError";

	@Parameters("browserName")
	@BeforeTest
	public void LaunchBrowser(String browserName) {
		LaunchBrowser(browserName, "");
	}

	@AfterTest
	public void tearDown() {
		driver().quit();
	}

	@Test
	public void testJSError() throws Exception {

		AllActionsPage aap = new AllActionsPage();

		aap.jsErrorLi.click();

		LogEntries errors = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : errors) {
			if (entry.getMessage().contains(JS_ERROR_TYPEERROR)) {
				assertEquals(entry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')"), true);
				System.out.println("JS Error found : " + entry.getMessage());
			}
		}

		waitBeforeClosingBrowser();

	}
}
