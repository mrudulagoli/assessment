package com.tests.assessment;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.AllActionsPage;

public class TC003_AllActionsTest2 extends BaseClass   {
	
	@Parameters("browserName")
	@BeforeTest
	public void LaunchBrowser(String browserName) {
		LaunchBrowser(browserName, "");
	}
	
	@Test
	public void submitLogin() throws Exception {
		
		AllActionsPage aap = new AllActionsPage();
		
		
		aap.checkBoxLi.click();
		Thread.sleep(2000);
		driver.navigate().back();		
		Thread.sleep(2000);		
		
		aap.contextMenuLi.click();
		Thread.sleep(2000);
		driver.navigate().back();  
		Thread.sleep(2000);	
		
		aap.dragNdropLi.click();
		Thread.sleep(2000);
		driver.navigate().back(); 
		Thread.sleep(2000);	
		
		aap.dropdownLi.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);	
		
		aap.dynamicContentLi.click();
		Thread.sleep(2000);
		driver.navigate().back();  
		Thread.sleep(2000);	
		
		aap.dynamicControlsLi.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);	
		
		aap.dynamicLoadingLi.click();
		Thread.sleep(2000);
		driver.navigate().back();  
		Thread.sleep(2000);	
		
		aap.fileDownloadLi.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);	
		
		aap.fileUploadLi.click();
		Thread.sleep(2000);
		driver.navigate().back(); 
		Thread.sleep(2000);	
		
		aap.floatingMenuLi.click();
		Thread.sleep(2000);
		driver.navigate().back(); 
		Thread.sleep(2000);	
		
		aap.framesLi.click();
		driver.navigate().back();
		Thread.sleep(2000);	
		
		aap.hoverLi.click();
		Thread.sleep(2000);
		driver.navigate().back(); 
		Thread.sleep(2000);	
		
		aap.jsAlertLi.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);	
		
		aap.jsErrorLi.click();
		Thread.sleep(2000);
		driver.navigate().back(); 
		Thread.sleep(2000);	
		
		aap.multiWindowLi.click();
		Thread.sleep(2000);
		driver.navigate().back(); 
		Thread.sleep(2000);	
		
		aap.notigMsgLi.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);	
	}
}
