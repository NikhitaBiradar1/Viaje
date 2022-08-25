package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viaje.genericutility.WebDriverUtility;

public class AdminHomePage {
	WebDriver driver;
	WebDriverUtility wUtility = new WebDriverUtility();

	@FindBy(xpath = "//a/descendant::span[.=' Tour Packages']")
	private WebElement TourPackageBtn;

	@FindBy(xpath = "//a[.='Create']")
	private WebElement TourPackageCreateBtn;

	@FindBy(xpath = "//a[.='Manage']")
	private WebElement TourPackageManageBtn;

	@FindBy(xpath = "//a[@class='dropdown-toggle']/descendant::i[@class='fa fa-angle-down']")
	private WebElement administortorDropDown;

	@FindBy(xpath = "//a[.=' Profile']")
	private WebElement adminProfileBtn;

	@FindBy(xpath = "//a[.=' Logout']")
	private WebElement adminLogoutBtn;

	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void AdminProfile()
	{
		administortorDropDown.click();
		adminProfileBtn.click();
	}

	public void LogoutAsAdmin()
	{
		administortorDropDown.click();
		adminLogoutBtn.click();	
	}

	public void CreateTourPackage()
	{
		//Mousehover Action
		//TourPackageBtn.click(); 
		wUtility.mouseOverOnElement(driver, TourPackageBtn);
		TourPackageCreateBtn.click();
	}

	public void ManageTourPackage()
	{
		//Mousehover Action
		//TourPackageBtn.click();
		wUtility.mouseOverOnElement(driver, TourPackageBtn);
		TourPackageManageBtn.click();
	}

	@FindBy(xpath = "//span[.='Manage Users']")
	private WebElement manageUser;

	@FindBy(xpath = "//span[.='Manage Booking']")
	private WebElement manageBookings;

	@FindBy(xpath = "//span[.='Manage Issues']")
	private WebElement manageIssues;

	@FindBy(xpath = "//span[.='Manage Enquiries']")
	private WebElement manageEnquiries;

	@FindBy(xpath = "//span[.='Manage Pages']")
	private WebElement ManagePages;

	@FindBy(xpath = "//div[@class='four-text']/child::h3[.='User']/following-sibling::h4")
	private WebElement userCount;

	@FindBy(xpath = "//div[@class='four-text']/child::h3[.='Bookings']/following-sibling::h4")
	private WebElement bookingsCount;

	@FindBy(xpath = "//div[@class='four-text']/child::h3[.='Enquiries']/following-sibling::h4")
	private WebElement enquiriesCount;

	@FindBy(xpath = "//div[@class='four-text']/child::h3[.='Toatal packages']/following-sibling::h4")
	private WebElement totalPackagesCount;

	@FindBy(xpath = "//div[@class='four-text']/child::h3[.='Issues Riaised']/following-sibling::h4")
	private WebElement issueRaisedCount;

	public WebElement getAdministortorDropDown() {
		return administortorDropDown;
	}

	public WebElement getAdminLogoutBtn() {
		return adminLogoutBtn;
	}

	public WebElement getManageUser() {
		return manageUser;
	}

	public WebElement getManageBookings() {
		return manageBookings;
	}

	public WebElement getManageIssues() {
		return manageIssues;
	}

	public WebElement getManageEnquiries() {
		return manageEnquiries;
	}

	public WebElement getManagePages() {
		return ManagePages;
	}

	public String getUserCount()
	{
		String count = userCount.getText();
		return count;
	}

	public String getBookingCount()
	{
		String users = bookingsCount.getText();
		return users;
	}

	public String getEnquiriesCount()
	{
		String count = enquiriesCount.getText();
		return count;		
	}

	public String getTotalPackagesCount()
	{
		String count = totalPackagesCount.getText();
		return count;
	}

	public String getIssuesRaisedCount()
	{
		String count = issueRaisedCount.getText();
		return count;
	}
}
