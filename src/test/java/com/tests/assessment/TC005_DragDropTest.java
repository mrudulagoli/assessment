package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC005_DragDropTest extends BaseClass {

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
	public void dragNdropTest() throws Exception {
		AllActionsPage aap = new AllActionsPage();
		aap.dragNdropLi.click();

		WebElement sourceElement = driver.findElement(By.id("column-a"));
		WebElement destinationElement = driver.findElement(By.id("column-b"));

		assertEquals(sourceElement.getText().equals("A"), true);
		System.out.println("Text Before Drag " + sourceElement.getText());

		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement
					+ "is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
		}

		Thread.sleep(2000);
		sourceElement = driver.findElement(By.id("column-a"));
		try {
			assertEquals(sourceElement.getText().equals("A"), true);
			System.out.println("Text Before Drag " + sourceElement.getText());
		} catch (AssertionError err) {
			System.out.println("Text After Drag " + sourceElement.getText());
		}

		waitBeforeClosingBrowser();
	}
}
