package com.viaje.pomrepositylib;

import java.awt.print.Pageable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTourPackagePage {
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
	
	@FindBy(id = "packageimage")
	private WebElement packageImage;
	
	@FindBy(xpath = "//button[.='Create']")
	private WebElement createBtn;
	
	@FindBy(xpath = "//button[.='Reset']")
	private WebElement resetBtn;
	
	public CreateTourPackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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

	public WebElement getPackageImage() {
		return packageImage;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

}
