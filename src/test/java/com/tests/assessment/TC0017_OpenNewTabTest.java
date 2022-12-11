package com.tests.assessment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0017_OpenNewTabTest extends BaseClass {

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
	public void openNewTabTest() throws Exception {

		AllActionsPage aap = new AllActionsPage();

		aap.multiWindowLi.click();
		String parenthandle = driver.getWindowHandle();
		WebElement window1 = driver.findElement(By.xpath("//a[text()='Click Here']"));
		window1.click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		assertEquals(allWindowHandles.size() > 1, true);
		System.out.println("New Tab is opened");
		for (String handle : allWindowHandles) {
			if (!handle.equals(parenthandle)) {
				driver.switchTo().window(handle);
				System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
			}
		}
		waitBeforeClosingBrowser();
	}
}
