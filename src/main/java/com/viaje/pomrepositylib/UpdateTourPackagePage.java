package com.viaje.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateTourPackagePage {
	@FindBy(id = "packagename")
	private WebElement packageName;
	
	@FindBy(id = "packagetype")
	private WebElement packageType;
	
	@FindBy(id = "packagelocation")
	private WebElement packageLocation;
	
	@FindBy(id = "packageprice")
	private WebElement packagePrice;
	
	@FindBy(id = "packagefeatures")
	private WebElement packageFeatures;
	
	@FindBy(xpath = "//textarea[@id='packagedetails']")
	private WebElement packageDetails;
	
	@FindBy(xpath = "//a[.='Change Image']")
	private WebElement changeImage;
	
	@FindBy(xpath = "//input[@id='packageimage']")
	private WebElement changeImageBrowseBtn;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement changeImageUploadBtn;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	public void getChangeImage(String filePath)
	{
		changeImage.click();
		changeImageBrowseBtn.sendKeys(filePath);
		changeImageUploadBtn.click();	
	}

	public WebElement getPackageName() {
		return packageName;
	}

	public WebElement getPackageType() {
		return packageType;
	}

	public WebElement getPackageLocation() {
		return packageLocation;
	}

	public WebElement getPackagePrice() {
		return packagePrice;
	}

	public WebElement getPackageFeatures() {
		return packageFeatures;
	}

	public WebElement getPackageDetails() {
		return packageDetails;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
}
