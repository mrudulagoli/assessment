package com.assessment.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assessment.base.BaseClass;

public class AllActionsPage extends BaseClass {
	
	@FindBy(xpath="//a[text()='Checkboxes']")
	public WebElement checkBoxLi;
	
	@FindBy(xpath="//a[text()='Context Menu']")
	public WebElement contextMenuLi;
	
	@FindBy(xpath="//a[text()='Drag and Drop']")
	public WebElement dragNdropLi;
	
	@FindBy(xpath="//a[text()='Dropdown']")
	public WebElement dropdownLi;
	
	@FindBy(xpath="//a[text()='Dynamic Content']")
	public WebElement dynamicContentLi;
	
	@FindBy(xpath="//a[text()='Dynamic Controls']")
	public WebElement dynamicControlsLi;
	
	@FindBy(xpath="//a[text()='Dynamic Loading']")
	public WebElement dynamicLoadingLi;
	
	@FindBy(xpath="//a[text()='File Download']")
	public WebElement fileDownloadLi;
	
	@FindBy(xpath="//a[text()='File Upload']")
	public WebElement fileUploadLi;
	
	@FindBy(xpath="//a[text()='Floating Menu']")
	public WebElement floatingMenuLi;
	
	@FindBy(xpath="//a[text()='Frames']")
	public WebElement framesLi;
	
	@FindBy(xpath="//a[text()='Hovers']")
	public WebElement hoverLi;
	
	@FindBy(xpath="//a[text()='JavaScript Alerts']")
	public WebElement jsAlertLi;
	
	@FindBy(xpath="//a[text()='JavaScript onload event error']")
	public WebElement jsErrorLi;
	
	@FindBy(xpath="//a[text()='Multiple Windows']")
	public WebElement multiWindowLi;
	
	@FindBy(xpath="//a[text()='Notification Messages']")
	public WebElement notigMsgLi;
	
	public AllActionsPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public void mousehover() {
		Actions act = new Actions(driver);
		act.moveToElement(hoverLi).build().perform();
		
	}
}
