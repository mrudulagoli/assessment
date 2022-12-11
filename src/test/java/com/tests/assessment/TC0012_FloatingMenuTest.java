package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0012_FloatingMenuTest extends BaseClass {

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
	public void floatingMenuTest() throws Exception {

		AllActionsPage aap = new AllActionsPage();

		aap.floatingMenuLi.click();

		WebElement lastElement = driver.findElement(By.id("page-footer"));
		int y = lastElement.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + y + ")");
		
		WebElement floatMenu = driver.findElement(By.id("menu"));
		
		assertEquals(floatMenu.isDisplayed(), true);
		System.out.println("Float menu is still displayed after scroll");
		
		waitBeforeClosingBrowser();

	}
}
