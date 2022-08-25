package org.viaje.adminmodulepom.test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.viaje.genericutility.ExcelUtility;
import com.viaje.genericutility.FileUtility;
import com.viaje.genericutility.WebDriverUtility;
import com.viaje.pomrepositylib.AdminHomePage;
import com.viaje.pomrepositylib.AdminLoginPage;
import com.viaje.pomrepositylib.TMSWelcomePage;
import com.viaje.pomrepositylib.UpdatePageDataPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManagePagePOMTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		int flagcount = 0;
		WebDriverUtility wDriverUtility = new WebDriverUtility();

		//Step 1: Read all the necessary common data from property file
		FileUtility fUtility = new FileUtility();
		String url = fUtility.getPropertyKeyValue("url");
		String browser = fUtility.getPropertyKeyValue("browser");

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
		TMSWelcomePage welcome = new TMSWelcomePage(driver);
		welcome.adminPageClick();
		
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		adminLogin.LoginToAdminDefaulty();
		
		AdminHomePage adminHome = new AdminHomePage(driver);
		adminHome.getManagePages().click();
		
		UpdatePageDataPage updatePage = new UpdatePageDataPage(driver);
		ExcelUtility eUtility = new ExcelUtility();
		String data;
		String page;
		
		page = eUtility.getExcelData("Sheet1",0,8);
		data = eUtility.getExcelData("Sheet1",1,8);
		updatePage.updatePage(page, data);
		
		page = eUtility.getExcelData("Sheet1",0,9);
		data = eUtility.getExcelData("Sheet1",1,9);
		updatePage.updatePage(page, data);
		
		page = eUtility.getExcelData("Sheet1",0,10);
		data = eUtility.getExcelData("Sheet1",1,10);
		updatePage.updatePage(page, data);
		
		page = eUtility.getExcelData("Sheet1",0,11);
		
		data = eUtility.getExcelData("Sheet1",1,11);
		updatePage.updatePage(page, data);
		
		driver.close();
	}
}
