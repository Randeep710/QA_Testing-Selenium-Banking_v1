package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Username is provided");
		loginPage.setPassword(password);
		logger.info("Password is provided");
		loginPage.clickLoginBtn();
		logger.info("Login button is clicked");
		Thread.sleep(3000);
		
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		addCustomerPage.clickAddNewCustomer();
		logger.info("Add New Customer link is clicked");
		
		logger.info("Providing the customer details...");
		
		addCustomerPage.enterCustomerName("Lisa");
		logger.info("Customer name is entered");
		addCustomerPage.selectCustomertGender("male");
		logger.info("Customer gender is selected");
		addCustomerPage.selectCustomerDOB("09", "11", "1992");
		logger.info("Customer DOB is selected from the calendar");
		Thread.sleep(5000);
		addCustomerPage.enterCustomerAddress("India");
		logger.info("Customer address is entered");
		addCustomerPage.enterCustomerCity("Bengaluru");
		logger.info("Customer city is entered");
		addCustomerPage.enterCustomerState("Karnataka");
		logger.info("Customer state is entered");
		addCustomerPage.enterCustomerPin("560029");
		logger.info("Customer pin is entered");
		addCustomerPage.enterCustomerMobileNumber("1234567890");
		logger.info("Customer mobile number is entered");
		
		//For email we have to take unique email id for each customer. Hence, we use some randomly generated Strings
		String randomEmail = generateRandomString()+"@gmail.com";
		addCustomerPage.enterCustomerEmail(randomEmail);
		logger.info("Customer email id is entered");
		addCustomerPage.enterCustomerPassword("abc123");
		logger.info("Customer password is entered");
		Thread.sleep(3000);
		
		addCustomerPage.clickSubmit();
		logger.info("Submit button is clicked");
		//Thread.sleep(3000);
		
		logger.info("Validation for successful registration of a new customer is started...");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result == true) {
			Assert.assertTrue(true);
			logger.info("New Customer Registration test case is PASSED");
		} else {
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("New Customer Resgistration test case is FAILED");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
}