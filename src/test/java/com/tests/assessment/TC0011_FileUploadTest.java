package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.io.File;
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

public class TC0011_FileUploadTest extends BaseClass {

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
	public void fileUploadTest() throws Exception {

		AllActionsPage aap = new AllActionsPage();

		aap.fileUploadLi.click();
		WebElement fileUploadLink = driver.findElement(By.id("file-upload"));
		
		String path = "src/test/resources/image.jpg";
		File file = new File(new File(path).getAbsolutePath());
		
		fileUploadLink.sendKeys(file.getAbsolutePath());
		driver.findElement(By.id("file-submit")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='File Uploaded!']")));
		try {
			assertEquals(element.getText().contains("File Uploaded"), true);
			System.out.println("File Uploaded");
		} catch (AssertionError e) {
			System.out.println("File Upload Failed!!");
		}
		waitBeforeClosingBrowser();
	}
}
