package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC003_CheckboxesTest extends BaseClass {

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
	public void checkBoxesTest() throws Exception {
		AllActionsPage aap = new AllActionsPage();

		aap.checkBoxLi.click();

		List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		int size = AllCheckboxes.size();

		for (int i = 0; i < size; i++) {

			AllCheckboxes.get(i).click();
			try {
				assertEquals(AllCheckboxes.get(i).isSelected(), true);
				System.out.println("Checkbox " + (i + 1) + " Checked");
			} catch (AssertionError err) {
				System.out.println("Checkbox " + (i + 1) + " Unchecked");
			}

			waitBeforeClosingBrowser();

		}
	}
}

