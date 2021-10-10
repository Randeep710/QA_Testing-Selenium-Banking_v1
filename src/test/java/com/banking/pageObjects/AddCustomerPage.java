package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver localDriver;
	
	public AddCustomerPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	//Identify the Elements present in the Add new customer Page
	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement addNewCustomerLink;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement customerGender;
	
	@FindBy(how = How.NAME, using="dob")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPincode;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(how = How.NAME, using="res")
	@CacheLookup
	WebElement resetBtn;
	
	//Action methods for above Elements
	public void clickAddNewCustomer() {
		addNewCustomerLink.click();
	}
	
	public void enterCustomerName(String customerName) {
		txtCustomerName.sendKeys(customerName);
	}
	
	public void selectCustomertGender(String gender) {
		customerGender.click();
	}
	
	public void selectCustomerDOB(String date, String month, String year) {
		txtDOB.sendKeys(date);
		txtDOB.sendKeys(month);
		txtDOB.sendKeys(year);
	}
	
	public void enterCustomerAddress(String address) {
		txtAddress.sendKeys(address);
	}
	
	public void enterCustomerCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void enterCustomerState(String state) {
		txtState.sendKeys(state);
	}
	
	public void enterCustomerPin(String pin) {
		txtPincode.sendKeys(pin);
	}
	
	public void enterCustomerMobileNumber(String mobileNo) {
		txtMobileNumber.sendKeys(String.valueOf(mobileNo));
	}
	
	public void enterCustomerEmail(String emailId) {
		txtEmail.sendKeys(emailId);
	}
	
	public void enterCustomerPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public void clickReset() {
		resetBtn.click();
	}
	
	
	

}
