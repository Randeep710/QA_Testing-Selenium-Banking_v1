package com.banking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_LoginPageTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		//driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.setUserName(username);
		logger.info("Entered username");
		
		loginPage.setPassword(password);
		logger.info("Entered password");
		
		loginPage.clickLoginBtn();
		
		if(driver.getTitle().equals(pageTitleOnSuccessfulLogin)) {
			Assert.assertTrue(true);
			logger.info("Login test PASSED!");
		} else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test FAILED!");
		}
	}
}
