package com.Products_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class CreateProd_GenericUtils {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = null;
		
		//fetch the common data using property file
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
			String prodName =eLib.readDataFromExcel("Products", 1, 0);
			String startDate =eLib.readDataFromExcel("Products", 1, 1);
			String prodCate =eLib.readDataFromExcel("Products", 1, 2);
		
		
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
				driver.findElement(By.linkText("Products")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
				driver.findElement(By.name("productname")).sendKeys(prodName+jLib.getRandomNo());
				//click on start date
				driver.findElement(By.xpath("//img[@id='jscal_trigger_sales_start_date']")).click();
				
			//	driver.findElement(By.xpath("//td[text()='September, 2023']/ancestor::div[@class='calendar']/descendant::td[text()='10']")).click();
	
			driver.findElement(By.name("sales_start_date")).sendKeys(startDate);
	
			WebElement prodCategory = driver.findElement(By.xpath("//select[@name='productcategory']"));
			
			Select sel = new Select(prodCategory);
			sel.selectByVisibleText(prodCate);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			System.out.println("product is created");
			
			//signout
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
			WebElement signOut = driver.findElement(By.linkText("Sign Out"));
			
			wLib.mousehover(driver, signOut);
		
			driver.quit();

	}

}
