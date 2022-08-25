package org.viaje.usermodule.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.viaje.genericutility.ExcelUtility;
import com.viaje.genericutility.FileUtility;
import com.viaje.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		WebDriverUtility wDriverUtility = new WebDriverUtility();

		//Step 1: Read all the necessary common data from property file
		FileUtility fUtility = new FileUtility();
		String url = fUtility.getPropertyKeyValue("url");
		String browser = fUtility.getPropertyKeyValue("browser");
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

		//Step 3: Login as User
		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
		driver.findElement(By.xpath("//h3[.='Signin with your account ']"
				+ "/following-sibling::input[@id='email']")).sendKeys(user);
		driver.findElement(By.xpath("//h3[.='Signin with your account ']"
				+ "/following-sibling::input[@id='password']")).sendKeys(userPassword);
		driver.findElement(By.name("signin")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		WebElement packageName = driver.findElement(By.xpath("//div[@class='room-bottom']/descendant::h4"));
		
	}

}
