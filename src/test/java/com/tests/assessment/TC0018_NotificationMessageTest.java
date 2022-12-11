package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0018_NotificationMessageTest extends BaseClass {

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
	public void NotificationMessageTest() throws Exception {

		AllActionsPage aap = new AllActionsPage();

		aap.notigMsgLi.click();
		for (int i = 1; i <= 4; i++) {
			WebElement aClickHere = driver.findElement(By.xpath("//a[text()='Click here']"));
			aClickHere.click();
			Thread.sleep(2000);
			try {
				SoftAssert softAssert = new SoftAssert();
				assertEquals(driver.findElement(By.id("flash")).getText().contains("Action successful"), true);
				System.out.println("Action successful !!");
			} catch (AssertionError e) {
				System.out.println("Action unsuccesful, please try again");
			}
		}
		waitBeforeClosingBrowser();

	}
}
