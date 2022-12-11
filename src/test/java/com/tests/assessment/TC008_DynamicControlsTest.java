package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC008_DynamicControlsTest extends BaseClass {

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
	public void testDynamicControls() throws Exception {
		AllActionsPage aap = new AllActionsPage();

		aap.dynamicControlsLi.click();

		WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
		removeBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean elementHidden = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
		try {
			assertEquals(elementHidden, true);
			System.out.println("Check box is not visible");
		} catch (AssertionError err) {

		}
		
		WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add']"));
		addBtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")))
				.isDisplayed();
		try {
			assertEquals(isDisplayed, true);
			System.out.println("Check box is visible");
		} catch (AssertionError err) {

		}
		
		WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableBtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
				
		try {
			assertEquals(element.isEnabled(), true);
			System.out.println("Textbox Enabled");
		} catch (AssertionError err) {

		}
		
		WebElement disableBtn = driver.findElement(By.xpath("//button[text()='Disable']"));
		disableBtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean t= wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))));
				
		try {
			assertEquals(t, true);
			System.out.println("Textbox Disabled");
		} catch (AssertionError err) {

		}
		waitBeforeClosingBrowser();

	}
}
