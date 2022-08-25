package org.viaje.adminmoduletestng;

import org.testng.annotations.Test;

import com.viaje.genericutility.BaseClass;
import com.viaje.genericutility.ExcelUtility;
import com.viaje.pomrepositylib.AdminHomePage;
import com.viaje.pomrepositylib.UpdatePageDataPage;

public class ManagePageTestngTest extends BaseClass{
	@Test
	public void Manage() throws Throwable
	{
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
	}

}
