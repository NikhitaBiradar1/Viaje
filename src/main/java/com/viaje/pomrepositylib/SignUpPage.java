package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	@FindBy(xpath = "//h3[.='Create your account ']/ancestor::div[@class='modal-content']"
			+ "/descendant::button[@class='close' and @aria-label='Close']/child::span[.='�']")
	private WebElement closeSigup;

	@FindBy(xpath = "//input[@placeholder='Full Name']")
	private WebElement fullName;

	@FindBy(xpath = "//input[@placeholder='Mobile number']")
	private WebElement mobNumber;

	@FindBy(xpath = "//input[@placeholder='Email id']")
	private WebElement emailId;

	@FindBy(xpath = "//h3[.='Create your account ']/following-sibling::input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='CREATE ACCOUNT']")
	private WebElement createAccountBtn;

	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCloseSigup() {
		return closeSigup;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getMobNumber() {
		return mobNumber;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}
}
