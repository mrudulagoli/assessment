package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0015_JavaScriptAlertsTest extends BaseClass   {
	
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
	public void testJSAlerts() throws Exception {
		
		AllActionsPage aap = new AllActionsPage();		
		
		aap.jsAlertLi.click();
		
		WebElement btn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		btn.click();
		
		//Alert
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();		
		assertEquals(alertText.contains("I am a JS Alert"), true);
		Thread.sleep(2000);
		System.out.println(alertText);
		alert.accept();
		
		Thread.sleep(2000);
		//Confirm
		btn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		btn.click();		
		alert = driver.switchTo().alert();
		alertText = alert.getText();	
		assertEquals(alertText.contains("I am a JS Confirm"), true);
		System.out.println(alertText);
		Thread.sleep(2000);
		alert.accept();
		
		Thread.sleep(2000);
		//prompt		
		btn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		btn.click();
		alert = driver.switchTo().alert();
		alertText = alert.getText();
		assertEquals(alertText.contains("I am a JS prompt"), true);
		System.out.println(alertText);
		alert.sendKeys("Assessment");
		Thread.sleep(2000);
		alert.accept();
		WebElement result = driver.findElement(By.id("result"));
		assertEquals(result.getText().contains("Assessment"), true);
		System.out.println(result.getText());
		
		waitBeforeClosingBrowser();
	}
}
