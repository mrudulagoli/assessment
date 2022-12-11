package com.tests.assessment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assessment.base.BaseClass;
import com.assessment.pageobject.LoginPage;


public class TC001_Login extends BaseClass {

	@Parameters("browserName")
	@BeforeTest
	public void LaunchBrowser(String browserName) {
		LaunchBrowser(browserName, "login");
	}

	@AfterTest
	public void tearDown() {
		driver().quit();
	}

	@Test(priority = 1)
	public void enterLoginDetails() throws Exception {
		LoginPage lp = new LoginPage();
		lp.enterIdPassword();
	}

	@Test(priority = 2)
	public void submitValidLogin() throws Exception {
		LoginPage lp = new LoginPage();
		lp.loginButton();
		try {
			assertEquals(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"), true);
			System.out.println("Login Sucessful !!");
		} catch (Exception e) {
			System.out.println("Login Failed");
		}
		Thread.sleep(1000);
		lp.logout.click();
		assertEquals(driver.findElement(By.id("flash")).getText().contains("You logged out of the secure area!"), true);
		System.out.println("Logout Sucessful !!");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void enterinvalidLoginDetails() throws Exception {
		LoginPage lp = new LoginPage();
		lp.enterInvalidCredentials();
	}

	@Test(priority = 4)
	public void submitinvalidLogin() throws Exception {
		LoginPage lp = new LoginPage();
		lp.loginButton();
		WebElement elem = driver.findElement(By.id("flash"));
		assertEquals(elem.getText().contains("Your username is invalid!"), true);
		System.out.println("Invalid Login Credentials Entered !!");

		Thread.sleep(1000);
	}

}
