package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	@FindBy(xpath = "//a[.='My Profile']")
	private WebElement userMyProfile;
	
	@FindBy(xpath = "//a[.='Change Password']")
	private WebElement changePassword;
	
	@FindBy(xpath = "//a[.='My Tour History']")
	private WebElement MyTourHistory;
	
	@FindBy(xpath = "//a[.='Issue Tickets']")
	private WebElement IssueTickets;
	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement Home;
	
	@FindBy(xpath = "//a[.='About']")
	private WebElement about;
	
	@FindBy(xpath = "//a[.='Tour Packages']")
	private WebElement tourPackages;
	
	@FindBy(xpath = "//div[@class='footer-btm wow fadeInLeft animated animated']/descendant::a[.='Privacy Policy']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//div[@class='footer-btm wow fadeInLeft animated animated']/descendant::a[.='Terms of Use']")
	private WebElement tearmsToUse;
	
	@FindBy(xpath = "//div[@class='footer-btm wow fadeInLeft animated animated']/descendant::a[.='Contact Us']")
	private WebElement contactUs;
	
	@FindBy(xpath = "//div[@class='footer-btm wow fadeInLeft animated animated']/descendant::a[.=' / Write Us ']")
	private WebElement writeUs;
	
	@FindBy(xpath = "//a[.='/ Logout']")
	private WebElement logout;
	
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void userLogout()
	{
		logout.click();
	}

	public WebElement getUserMyProfile() {
		return userMyProfile;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getMyTourHistory() {
		return MyTourHistory;
	}

	public WebElement getIssueTickets() {
		return IssueTickets;
	}

	public WebElement getHome() {
		return Home;
	}

	public WebElement getAbout() {
		return about;
	}

	public WebElement getTourPackages() {
		return tourPackages;
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}

	public WebElement getTearmsToUse() {
		return tearmsToUse;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getWriteUs() {
		return writeUs;
	}
	
}
