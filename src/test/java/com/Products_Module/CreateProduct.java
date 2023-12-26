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

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		
		
		WebDriver driver = null;
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		//fetch the common data using property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\JsonCommonData.json");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read the data from Excel sheet
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData51.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Products");
		String prodName = sh.getRow(1).getCell(0).getStringCellValue();
		String startDate = sh.getRow(1).getCell(1).getStringCellValue();
		String prodCate = sh.getRow(1).getCell(2).getStringCellValue();
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
				
		driver.manage().window().maximize();
				
				//enter the url
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//enter valid UN & PWD
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				//click on Org link
				driver.findElement(By.linkText("Products")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
				driver.findElement(By.name("productname")).sendKeys(prodName+random);
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
			
			Actions act = new Actions(driver);
			act.moveToElement(signOut).click().perform();
		
			driver.close();
	}
}












