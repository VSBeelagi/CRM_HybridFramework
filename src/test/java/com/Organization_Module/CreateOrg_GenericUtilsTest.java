package com.Organization_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericUtils.DatabaseUtility;
import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.FileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;

public class CreateOrg_GenericUtilsTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;
		
		//create object for all utility classes
		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		
		//fetch the common data using property file
		String BROWSER = fLib.readDataFromPropetyFile("browser");
		String URL = fLib.readDataFromPropetyFile("url");
		String USERNAME = fLib.readDataFromPropetyFile("username");
		String PASSWORD = fLib.readDataFromPropetyFile("password");
		
		//read the data from Excel sheet
		String typeDD = eLib.readDataFromExcel("Organization", 1, 3);
		String indDD = eLib.readDataFromExcel("Organization", 1, 4);
	
		//launch the browser
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		
				
				//enter the url
				driver.get(URL);
			
				wLib.waitForPageLoad(driver);
				
				//enter valid UN & PWD
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				//click on Org link
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
				//enter the mandatory fields
				
				eLib.getMultipleDataFromExcel("Organization", 0, 1);
				
				
				
				WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
				WebElement ind = driver.findElement(By.xpath("//select[@name='industry']"));
				
				//Type dropdown
				wLib.select(typeDD, type);

				
				//industry dropdown
				wLib.select(indDD, ind);
				
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//get the confirmation msg
				String OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
				//validate
				if(OrgInfo.contains("TCS"))
				{
					System.out.println("Org is created");
				}
				else
				{
					System.out.println("Org is not created");
				}
				
					//signout
					driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				
					WebElement signOut = driver.findElement(By.linkText("Sign Out"));
					
					wLib.mousehover(driver, signOut);
				
					driver.quit();


	}

}
