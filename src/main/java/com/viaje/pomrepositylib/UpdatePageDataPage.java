package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.viaje.genericutility.WebDriverUtility;

public class UpdatePageDataPage {
	WebDriverUtility wUtility = new WebDriverUtility();
	
	@FindBy(xpath = "//select[@name='menu1']")
	private WebElement pageDropDown;
	
	@FindBy(xpath = "//div[@class='col-sm-8']"
				+ "/descendant::div[contains(@class,'nicEdit-main')]")
	private WebElement pageDetails;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement updateBtn;
	
	public UpdatePageDataPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPageDropDown() {
		return pageDropDown;
	}

	public WebElement getPageDetails() {
		return pageDetails;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public void updatePage(String pageName, String data) throws InterruptedException
	{
		wUtility.select(pageDropDown, pageName);
		pageDetails.clear();
		pageDetails.sendKeys(data);
		Thread.sleep(2000);
		updateBtn.click();
	}
}
