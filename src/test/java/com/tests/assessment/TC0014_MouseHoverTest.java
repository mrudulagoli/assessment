package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0014_MouseHoverTest extends BaseClass {

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
	public void mouseHover() throws Exception {

		AllActionsPage aap = new AllActionsPage();
		aap.hoverLi.click();
		Actions act = new Actions(driver);
		List<WebElement> images = driver.findElements(By.className("figure"));

		for (WebElement webElement : images) {
			act.moveToElement(webElement).perform();
			WebElement captionElement = webElement.findElement(By.className("figcaption"));
			assertEquals(captionElement.isDisplayed(), true);
			System.out.println("Image Caption : " + captionElement.getText());
		}
		
		waitBeforeClosingBrowser();
	}
}
