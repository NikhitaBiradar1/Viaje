package org.viaje.admin.tourpackage.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.protocol.a.TracingPacketReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTourPackageTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebElement browseImage;
		WebElement tourPackage;
		WebElement success;
		
		WebDriver driver = null;
		String url = null;
		String wait = null;
		String browser = null;
		String adminUser = null;
		String adminPassword = null;
		String user = null;
		String userPassword = null;
		String successFlag = "flase";
		
		
		String packageName = null;
		String packageType = null;
		String packageLocation = null;
		String packagePrice = null;
		String packageFeatures = null;
		String packageDetails = null;
		String packageImage = null;
		
		//Step 1: Read all the necessary common data
		FileInputStream fis = new FileInputStream(".\\ViajeData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		browser = prop.getProperty("browser");
		adminUser = prop.getProperty("adminUsername");
		adminPassword = prop.getProperty("adminPassword");
		wait = prop.getProperty("waittime");
		int waittime = Integer.parseInt(wait);
		
		//Step 2: Read the data from Excel Sheet
		FileInputStream fileExcel = new FileInputStream(".\\ViajeData\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fileExcel);
		Row row = book.getSheet("Sheet1").getRow(1);
		packageName = row.getCell(0).getStringCellValue();
		packageType = row.getCell(1).getStringCellValue();
		packageLocation = row.getCell(2).getStringCellValue();
		packagePrice = row.getCell(3).toString();
		packageFeatures = row.getCell(4).getStringCellValue();
		packageDetails = row.getCell(5).getStringCellValue();;
		packageImage = row.getCell(6).getStringCellValue();
				
		//Step 3: Launch the browser
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
		driver.manage().timeouts().implicitlyWait(waittime,TimeUnit.SECONDS);
		driver.get(url);
		
		//Step 4:Login to application as admin
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.name("username")).sendKeys(adminUser);
		driver.findElement(By.name("password")).sendKeys(adminPassword);
		driver.findElement(By.name("login")).click();
		
		//Step 5: Create a tour package
		//Step 5.1: Navigate to Tour Package module
		//Mouse hover to Tour Packages
		tourPackage = driver.findElement(By.xpath("//span[.=' Tour Packages']"));
		Actions act = new Actions(driver);
		act.moveToElement(tourPackage).perform();
		driver.findElement(By.xpath("//a[.='Create']")).click();	
		
		//Step 5.2: Enter all the details and click on submit
		driver.findElement(By.name("packagename")).sendKeys(packageName);
		driver.findElement(By.name("packagetype")).sendKeys(packageType);
		driver.findElement(By.name("packagelocation")).sendKeys(packageLocation);
		driver.findElement(By.name("packageprice")).sendKeys(packagePrice);
		driver.findElement(By.name("packagefeatures")).sendKeys(packageFeatures);
		driver.findElement(By.name("packagedetails")).sendKeys(packageDetails);
		browseImage = driver.findElement(By.name("packageimage"));
		browseImage.sendKeys(packageImage);
		Thread.sleep(2000);

		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		success = driver.findElement(By.xpath("//strong[.='SUCCESS']"));
		successFlag = success.getText();
		if(successFlag.equalsIgnoreCase("success"))
			System.out.println("Test case is pass");
		else
			System.out.println("Test case is fail");
		
		//Step 6: Close the application
		driver.findElement(By.xpath("//span[.='Administrator']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.findElement(By.xpath("//a[.='Back to home']")).click();
		
		//Step 7: Close the browser
		driver.close();
	}
	
	
}
