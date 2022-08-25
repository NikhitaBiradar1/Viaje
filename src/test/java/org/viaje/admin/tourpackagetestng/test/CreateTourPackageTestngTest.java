package org.viaje.admin.tourpackagetestng.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import com.viaje.genericutility.BaseClass;
import com.viaje.genericutility.WebDriverUtility;
import com.viaje.pomrepositylib.AdminHomePage;
import com.viaje.pomrepositylib.CreateTourPackagePage;

public class CreateTourPackageTestngTest extends BaseClass{
	
	AdminHomePage aHome ;
	
	@Test
	public void TourPackage() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(2000);
		
		String packageName = null;
		String packageType = null;
		String packageLocation = null;
		String packagePrice = null;
		String packageFeatures = null;
		String packageDetails = null;
		String packageImage = null;
		
		FileInputStream fileExcel = new FileInputStream(".\\ViajeData\\TestData.xlsx");
		
		//An object should be created within @Test annotation --> because after
		//executing @BeforeMethod the control come to @Test
		//if we create ouside, it will give null pointer exception
		aHome = new AdminHomePage(driver);
		aHome.CreateTourPackage();
		Thread.sleep(2000);
		
		Workbook book = WorkbookFactory.create(fileExcel);
		Row row = book.getSheet("Sheet1").getRow(1);
		packageName = row.getCell(0).getStringCellValue();
		packageType = row.getCell(1).getStringCellValue();
		packageLocation = row.getCell(2).getStringCellValue();
		packagePrice = row.getCell(3).toString();
		packageFeatures = row.getCell(4).getStringCellValue();
		packageDetails = row.getCell(5).getStringCellValue();;
		packageImage = row.getCell(6).getStringCellValue();
		
		CreateTourPackagePage createPackage = new CreateTourPackagePage(driver);
		createPackage.getPackageName().sendKeys(packageName);
		createPackage.getPackageType().sendKeys(packageType);
		createPackage.getPackageLocation().sendKeys(packageLocation);
		createPackage.getPackagePrice().sendKeys(packagePrice);
		createPackage.getPackageFeatures().sendKeys(packageFeatures);
		createPackage.getPackageDetails().sendKeys(packageDetails);
		createPackage.getPackageImage().sendKeys(packageImage);
		createPackage.getCreateBtn().click();
	}

}
