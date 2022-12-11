package com.assessment.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assessment.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "username")
	WebElement Username;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
	WebElement submitLogin;

	@FindBy(xpath = "//i[text()= ' Logout']")
	public WebElement logout;

	@FindBy(xpath = "//h4[@class='subheader']")
	WebElement WelcomeText;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterIdPassword() throws Exception {
		Username.clear();
		Password.clear();
		Thread.sleep(2000);
		Username.sendKeys(prop.getProperty("username_valid"));
		Password.sendKeys(prop.getProperty("password_valid"));
	}

	public void enterInvalidCredentials() throws Exception {
		Username.clear();
		Password.clear();
		Thread.sleep(2000);
		Username.sendKeys(prop.getProperty("username_invalid"));
		Password.sendKeys(prop.getProperty("password_valid"));
	}

	public void loginButton() throws Exception {
		Thread.sleep(2000);
		submitLogin.click();
	}

}
