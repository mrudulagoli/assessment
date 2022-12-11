package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0013_IframeTest extends BaseClass   {
	
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
	public void iframeTest() throws Exception {
		
		AllActionsPage aap = new AllActionsPage();		
		aap.framesLi.click();
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		driver.switchTo().frame("mce_0_ifr");
		//driver.findElement(By.xpath("/html/body/div[4]/div/div/button/div/svg")).click();
		WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']//p"));
		textBox.clear();
		textBox.sendKeys("this is my assessment");	
		textBox = driver.findElement(By.xpath("//body[@id='tinymce']//p"));
		
		assertEquals(textBox.getText().contains("this is my assessment"), true);
		
		waitBeforeClosingBrowser();
	}
}
