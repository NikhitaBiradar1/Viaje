package com.viaje.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.viaje.pomrepositylib.AdminHomePage;
import com.viaje.pomrepositylib.AdminLoginPage;
import com.viaje.pomrepositylib.TMSWelcomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	DataBaseUtility dLib = new DataBaseUtility();
	public WebDriver driver = null;

	// Connect to the database
	@BeforeSuite
	public void configBS() {
		System.out.println(".....Connect to the Database.....");
	}

	// Launch the browser
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("Launch the browser");
		String browser = fLib.getPropertyKeyValue("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);
	}

	// Login to the application
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Open the application welcome page");
		String URL = fLib.getPropertyKeyValue("url");
		driver.get(URL);
		
		System.out.println("Login to the application");
		TMSWelcomePage welcome = new TMSWelcomePage(driver);
		welcome.getAdminLoginLnk().click();
		
		AdminLoginPage aLogin = new AdminLoginPage(driver);
		aLogin.LoginToAdminDefaulty();
	}

	// Logout of the application
	@AfterMethod
	public void configAM() throws Throwable {
		System.out.println("Logout of the application");
		AdminHomePage aHome = new AdminHomePage(driver);
		aHome.LogoutAsAdmin();
	}

	// Close the Browser
	@AfterClass
	public void configAC() {
		System.out.println("Close the Browser");
		driver.close();
	}

	// Close the database connection
	@AfterSuite
	public void configAS() {
		System.out.println(".....Close the database connection.....");
	}
}
