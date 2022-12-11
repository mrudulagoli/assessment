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

public class TC009_DynamicLoadingTest extends BaseClass {

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
	public void dynamicLoadingTest() throws Exception {

		AllActionsPage aap = new AllActionsPage();
		aap.dynamicLoadingLi.click();

		WebElement a = driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']"));
		a.click();

		WebElement element = driver.findElement(By.xpath("//button[text()='Start']"));
		element.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

		WebElement textelement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		assertEquals(textelement.getText().contains("Hello World!"), true);
		System.out.println(textelement.getText());
		waitBeforeClosingBrowser();

	}
}