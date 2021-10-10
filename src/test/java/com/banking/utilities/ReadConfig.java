package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	
	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch(Exception e) {
			System.out.println("Exection encountered : "+e.getMessage());
		}
	}
	
	//Methods for each variable in config.propeties file
	public String getApplicationURL() {
		return properties.getProperty("baseURL");
	}
	
	public String getUsername() {
		return properties.getProperty("username");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	
	public String getChromePath() {
		return properties.getProperty("chromePath");
	}
	
	public String getFirefoxPath() {
		return properties.getProperty("firefoxPath");
	}
	
	public String getIEpath() {
		return properties.getProperty("iePath");
	}
}
