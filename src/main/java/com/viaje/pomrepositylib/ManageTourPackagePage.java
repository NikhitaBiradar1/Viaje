package com.viaje.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageTourPackagePage {
	WebDriver driver;
	
	public ManageTourPackagePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//If the xpath id dynamic --> Use driver.findElement method for dynamic xpath
	public void getTourDetails(String name)
	{
		driver.findElement(By.xpath("//td[@data-th='Name']/child::span[.='"+name+"']"
				+ "/parent::td[@data-th='Name']/following-sibling::td[@data-th='Action']"
				+ "/descendant::button[.='View Details']")).click();
	}
}
