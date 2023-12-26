package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
		
		//step1: object representation of physical file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2: object to property class
		Properties pObj = new Properties();
		
		//step3: load the keys
		pObj.load(fis);
		
		//step4: use getProperty to fetch the values
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	
	}

}
