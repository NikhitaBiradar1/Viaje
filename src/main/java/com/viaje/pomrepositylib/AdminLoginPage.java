package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viaje.genericutility.FileUtility;

public class AdminLoginPage {
	FileUtility fUtility = new FileUtility();
	
	@FindBy(className = "name")
	private WebElement adminUserName;
	
	@FindBy(className = "password")
	private WebElement adminPassword;
	
	@FindBy(className = "login")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[.='Back to home']")
	private WebElement welcomePageBtn;

	public WebElement getWelcomePageBtn() {
		return welcomePageBtn;
	}

	public WebElement getAdminUserName() {
		return adminUserName;
	}

	public WebElement getAdminPassword() {
		return adminPassword;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Default Admin Login Cedentials
	public void LoginToAdminDefaulty() throws Throwable
	{
		adminUserName.sendKeys(fUtility.getPropertyKeyValue("adminUsername"));
		adminPassword.sendKeys(fUtility.getPropertyKeyValue("adminPassword"));
		loginBtn.click();
	}
	
	//Admin Login With username and password
	public void LoginToAdminWithCredentials(String username, String password)
	{
		adminUserName.sendKeys(username);
		adminPassword.sendKeys(password);
		loginBtn.click();
	}

}
