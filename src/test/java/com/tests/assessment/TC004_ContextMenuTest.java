package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC004_ContextMenuTest extends BaseClass {

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
	public void contextMenuTest() throws Exception {
		AllActionsPage aap = new AllActionsPage();

		aap.contextMenuLi.click();

		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("hot-spot"));
		actions.contextClick(elementLocator).perform();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		assertEquals(alertText.contains("You selected a context menu"), true);
		System.out.println("You selected a context menu");

		Thread.sleep(2000);
		alert.accept();
		waitBeforeClosingBrowser();

	}
}
