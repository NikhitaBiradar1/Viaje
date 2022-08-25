package org.viaje.adminmodule.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.viaje.genericutility.ExcelUtility;
import com.viaje.genericutility.FileUtility;
import com.viaje.genericutility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ManagePagesTest {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;
		int flagcount = 0;
		WebDriverUtility wDriverUtility = new WebDriverUtility();

		//Step 1: Read all the necessary common data from property file
		FileUtility fUtility = new FileUtility();
		String url = fUtility.getPropertyKeyValue("url");
		String browser = fUtility.getPropertyKeyValue("browser");
		String adminUser = fUtility.getPropertyKeyValue("adminUsername");
		String adminPassword = fUtility.getPropertyKeyValue("adminPassword");
		String user = fUtility.getPropertyKeyValue("userUsername");
		String userPassword = fUtility.getPropertyKeyValue("userPassword");

		//Step 2: Launch the browser
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		wDriverUtility.waitForElementInDOM(driver);
		driver.get(url);

		//Step 3:Login to application as admin
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.name("username")).sendKeys(adminUser);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		driver.findElement(By.name("login")).click();

		//Step 4: Navigate to Manage Pages
		driver.findElement(By.xpath("//span[.='Manage Pages']")).click();
		
		WebElement dropdown1 = driver.findElement(By.name("menu1"));
		//Tearms and condition
		wDriverUtility.select(dropdown1,"terms and condition");
		
		
		//Step 5: Read Data from Excel
		ExcelUtility eUtility = new ExcelUtility();
		String tearmsAndConditions = eUtility.getExcelData("Sheet1", 1,8);
		WebElement text = driver.findElement(By.xpath("//div[@class='col-sm-8']"
				+ "/descendant::div[contains(@class,'nicEdit-main')]"));
		text.clear();
		text.sendKeys(tearmsAndConditions);

		driver.findElement(By.xpath("//button[@id='submit' and @name='submit']")).click();
		
		//Privacy and Policy
		dropdown1 = driver.findElement(By.name("menu1"));
		wDriverUtility.select(dropdown1,"privacy and policy");
		String privacyAndPolicy = eUtility.getExcelData("Sheet1",1,9);
		text = driver.findElement(By.xpath("//div[@class='col-sm-8']"
				+ "/descendant::div[contains(@class,'nicEdit-main')]"));
		text.clear();
		text.sendKeys(privacyAndPolicy);
		driver.findElement(By.xpath("//button[@id='submit' and @name='submit']")).click();
		
		//About us
		dropdown1 = driver.findElement(By.name("menu1"));
		wDriverUtility.select(dropdown1,"aboutus");
		String aboutUs = eUtility.getExcelData("Sheet1",1,10);
		text = driver.findElement(By.xpath("//div[@class='col-sm-8']"
				+ "/descendant::div[contains(@class,'nicEdit-main')]"));
		text.clear();
		text.sendKeys(aboutUs);
		driver.findElement(By.xpath("//button[@id='submit' and @name='submit']")).click();
		
		//Contact us
		dropdown1 = driver.findElement(By.name("menu1"));
		wDriverUtility.select(dropdown1,"Contact us");
		String contactUs = eUtility.getExcelData("Sheet1",1,11);
		text = driver.findElement(By.xpath("//div[@class='col-sm-8']"
				+ "/descendant::div[contains(@class,'nicEdit-main')]"));
		text.clear();
		text.sendKeys(contactUs);
		driver.findElement(By.xpath("//button[@id='submit' and @name='submit']")).click();
		

		//Step 6: Logout of the application as admin
		driver.findElement(By.xpath("//span[.='Administrator']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		
		//Step 7: Login as User
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//h3[.='Signin with your account ']/following-sibling::input[@id='email']")).sendKeys(user);
		driver.findElement(By.xpath("//h3[.='Signin with your account ']/following-sibling::input[@id='password']")).sendKeys(userPassword);
		driver.findElement(By.name("signin")).click();

		//Step 8: Validate
		driver.findElement(By.xpath("//a[.='Terms of Use']")).click();
		String fetchedtearmsAndConditions = driver.findElement(By.xpath("//h3[.='terms']"
				+ "/parent::div[@class='container']/p")).getText();
		if(tearmsAndConditions.equalsIgnoreCase(fetchedtearmsAndConditions))
		{
			flagcount++;
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Privacy Policy']")).click();
		String fetchedPrivacyAndPolicy = driver.findElement(By.xpath("//h3[.='privacy']"
				+ "/parent::div[@class='container']/p")).getText();
		if(privacyAndPolicy.equalsIgnoreCase(fetchedPrivacyAndPolicy))
		{
			flagcount++;
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Contact Us']")).click();
		String fetchedCountactUs = driver.findElement(By.xpath("//h3[.='contact']"
				+ "/parent::div[@class='container']/p")).getText();
		if(contactUs.equalsIgnoreCase(fetchedCountactUs))
		{
			flagcount++;
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='About']")).click();
		String fetchedAboutus = driver.findElement(By.xpath("//h3[.='aboutus']"
				+ "/parent::div[@class='container']/p")).getText();
		if(aboutUs.equalsIgnoreCase(fetchedAboutus))
		{
			flagcount++;
		}
		
		Thread.sleep(2000);

		if(flagcount==4)
			System.out.println("Testcase is Pass");
		else
			System.out.println("Testcase is Fail");
			
		//Step 9: Logout of application as user
		driver.findElement(By.xpath("//a[.='/ Logout']")).click();
			
		//Step 10: Close the driver
		Thread.sleep(5000);
		driver.close();
	}

}
