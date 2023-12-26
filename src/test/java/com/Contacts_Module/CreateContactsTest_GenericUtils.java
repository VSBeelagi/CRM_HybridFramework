package com.Contacts_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericUtils.DatabaseUtility;
import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.FileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;

public class CreateContactsTest_GenericUtils {

	public static void main(String[] args) throws Throwable {
		
		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//read data from property file
		String BROWSER = fLib.readDataFromPropetyFile("browser");
		String URL = fLib.readDataFromPropetyFile("url");
		String USERNAME = fLib.readDataFromPropetyFile("username");
		String PASSWORD = fLib.readDataFromPropetyFile("password");
		
		//data fetching from excel
		String lastName = eLib.readDataFromExcel("Contacts", 1, 0)+jLib.getRandomNo();
		String leadsource = eLib.readDataFromExcel("Contacts", 1, 1);
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		
		//enter the url
		driver.get(URL);
		
		wLib.waitForPageLoad(driver);
		
		//enter valid UN & PWD
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on Contacts link
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				
				WebElement leadsourceEle = driver.findElement(By.xpath("//select[@name='leadsource']"));
				
				wLib.select(leadsource, leadsourceEle);
//				Select sel = new Select(leadsource);
//				sel.selectByVisibleText("Employee");
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//validate the contacts
				String contInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
				System.out.println(contInfo);
				
				//signout
						driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
					
						WebElement signOut = driver.findElement(By.linkText("Sign Out"));
						
						wLib.mousehover(driver, signOut);
						
						driver.quit();


	}

}
