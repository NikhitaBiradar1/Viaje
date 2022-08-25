package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viaje.genericutility.FileUtility;

public class UserLoginPage {
	FileUtility fUtility = new FileUtility();
	
	@FindBy(xpath ="//div[@class='login-right']/descendant::input[@id='email' and @name='email' and @placeholder='Enter your Email']")
	private WebElement userUserName;
	
	@FindBy(xpath = "//div[@class='login-right']/descendant::input[@id='password' and @name='password']")
	private WebElement userPassword;
	
	@FindBy(xpath = "//input[@type='submit' and @name='signin']")
	private WebElement signinBtn;
	
	@FindBy(xpath = "//div[@class='modal-content modal-info']/descendant::button[@class='close' and @type='button']/child::span[.='�']")
	private WebElement closeSignin;

	public WebElement getCloseSignin() {
		return closeSignin;
	}

	public WebElement getUserUserName() {
		return userUserName;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginAsUser(String userName, String password)
	{
		userUserName.sendKeys(userName);
		userPassword.sendKeys(password);
		signinBtn.click();
	}
	
	public void LoginAsDefaultUser() throws Throwable
	{
		userUserName.sendKeys(fUtility.getPropertyKeyValue("userUsername"));
		userPassword.sendKeys(fUtility.getPropertyKeyValue("userPassword"));
		signinBtn.click();
	}
}
