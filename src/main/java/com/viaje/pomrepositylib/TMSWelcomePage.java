package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TMSWelcomePage {
	@FindBy(xpath = "//a[.='Sign Up']")
	private WebElement signUpLnk;
	
	@FindBy(xpath = "//a[.='/ Sign In']")
	private WebElement userLoginLnk;
	
	@FindBy(xpath = "//a[.='Admin Login']")
	private WebElement adminLoginLnk;
	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement homeLnk;
	
	@FindBy(xpath = "//a[.='About']")
	private WebElement AboutLnk;
	
	@FindBy(xpath = "//a[.='Tour Packages']")
	private WebElement tourPackageLnk;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/descendant::a[.='Privacy Policy']")
	private WebElement privacyPolicyLnk;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/descendant::a[.='Terms of Use']")
	private WebElement termsOfUseLnk;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/descendant::a[.='Contact Us']")
	private WebElement contactUsLnk;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/descendant::a[.=' Enquiry ']")
	private WebElement enquiryLnk;
	
	public TMSWelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignUpLnk() {
		return signUpLnk;
	}

	public WebElement getUserLoginLnk() {
		return userLoginLnk;
	}

	public WebElement getAdminLoginLnk() {
		return adminLoginLnk;
	}

	public WebElement getHomeLnk() {
		return homeLnk;
	}

	public WebElement getAboutLnk() {
		return AboutLnk;
	}

	public WebElement getTourPackageLnk() {
		return tourPackageLnk;
	}

	public WebElement getPrivacyPolicyLnk() {
		return privacyPolicyLnk;
	}

	public WebElement getTermsOfUseLnk() {
		return termsOfUseLnk;
	}

	public WebElement getContactUsLnk() {
		return contactUsLnk;
	}

	public WebElement getEnquiryLnk() {
		return enquiryLnk;
	}
	
	public void adminPageClick()
	{
		adminLoginLnk.click();
	}
}
