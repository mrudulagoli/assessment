package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

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

public class TC007_DynamicContentTest extends BaseClass {

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
	public void dynamicContentTest() throws Exception {
		AllActionsPage aap = new AllActionsPage();
		aap.dynamicContentLi.click();

		WebElement beforeRefresh = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/child::div[3]"));
		String prevText = beforeRefresh.getText();
		System.out.println(prevText);
		//List<WebElement> childDivsOriginal = driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div/child::div"));
		
		

		Thread.sleep(2000);

		WebElement refresh = driver.findElement(By.xpath("//a[text()='click here']"));
		refresh.click();

		Thread.sleep(2000);
		
		WebElement afterRefresh = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/child::div[3]"));
		//List<WebElement> childDivsAfterRefresh = driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div/child::div"));

		/*
		 * for (WebElement child : childDivsAfterRefresh) {
		 * 
		 * for (WebElement childO : childDivsOriginal) {
		 * assertEquals(childO.getText().equals(child.getText()), false);
		 * System.out.println("Not matched content refreshed"); }
		 * 
		 * }
		 */
		System.out.println(afterRefresh.getText());
		assertEquals(prevText.equals(afterRefresh.getText()), false);
		System.out.println("Not matched content refreshed");
		waitBeforeClosingBrowser();
	}

}
