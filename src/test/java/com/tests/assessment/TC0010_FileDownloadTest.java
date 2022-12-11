package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC0010_FileDownloadTest extends BaseClass   {
	
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
	public void fileDownloadTest() throws Exception {
		AllActionsPage aap = new AllActionsPage();
		
		aap.fileDownloadLi.click();
		

		WebElement fileDownloadLink = driver.findElement(By.xpath("//a[text()='some-file.txt']"));
		fileDownloadLink.click();
		
		Thread.sleep(3000);
		
		assertEquals(isFileDownloaded("some-file.txt"), true);
		System.out.println("File Downloaded Successfully !!!");
		
		waitBeforeClosingBrowser();
		
	}
	
	 public boolean isFileDownloaded(String filename) throws IOException
	 {
	         String downloadPath = System.getProperty("user.home");
	         File file = new File(downloadPath + "/Downloads/"+ filename);
	         boolean flag = (file.exists()) ? true : false ;
	         return flag;
	 }
}
