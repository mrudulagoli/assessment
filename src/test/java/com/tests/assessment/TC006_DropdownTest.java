package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC006_DropdownTest extends BaseClass   {
	
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
	public void dropdownTest() throws Exception {
		AllActionsPage aap = new AllActionsPage();
		
		
		aap.dropdownLi.click();
		
		Select dropdownSelect = new Select(driver.findElement(By.id("dropdown")));
		
		dropdownSelect.selectByIndex(1);
		WebElement option = dropdownSelect.getFirstSelectedOption();
		Thread.sleep(1000);		
		assertEquals(option.isSelected(), true);
		System.out.println(option.getText());
			
		dropdownSelect.selectByIndex(2);
		option = dropdownSelect.getFirstSelectedOption();
		Thread.sleep(1000);		
		assertEquals(option.isSelected(), true);
		System.out.println(option.getText() + " Selected");
		
		Thread.sleep(2000);	
	}
}
