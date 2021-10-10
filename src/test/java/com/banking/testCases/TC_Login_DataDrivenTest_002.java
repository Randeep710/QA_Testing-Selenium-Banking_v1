package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_Login_DataDrivenTest_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(user);
		logger.info("username provided");
		loginPage.setPassword(password);
		logger.info("password provided");
		loginPage.clickLoginBtn();
		logger.info("clicked on login button");
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login FAILED");
		} else {
			Assert.assertTrue(true);
			logger.info("Login PASSED");
			loginPage.clickLogoutLink();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	//User Defined Methods:
	//1. To verify whether alert pops up while logging in with invalid credentials
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/banking/testData/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String[][] loginData = new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}