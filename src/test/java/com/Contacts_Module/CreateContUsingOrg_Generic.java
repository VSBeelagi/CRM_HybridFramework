package com.Contacts_Module;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

public class CreateContUsingOrg_Generic {

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
		
		
		String OrgName = eLib.readDataFromExcel("Organization", 0, 1)+jLib.getRandomNo();
		String leadsource = eLib.readDataFromExcel("Contacts", 1, 1);
		String lastName = eLib.readDataFromExcel("Contacts", 1, 0)+jLib.getRandomNo();
		
		//launch the browser
				WebDriver driver = new ChromeDriver();
				wLib.maximizeWindow(driver);
				
				//enter the url
				driver.get(URL);
				
				wLib.waitForPageLoad(driver);
				
				//enter valid UN & PWD
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();

				//click on Org link
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
				//enter the mandatory fields
				driver.findElement(By.name("accountname")).sendKeys(OrgName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
				//get the confirmation msg
				String OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			
				//validate
				if(OrgInfo.contains(OrgName))
				{
					System.out.println("Org is created");
				}
				else
				{
					System.out.println("Org is not created");
				}

				//click on Contacts link
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				
				//switch to child window
				wLib.switchToWindow(driver, "Accounts");

				driver.findElement(By.name("search_text")).sendKeys("testyantra1");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='testyantra']")).click();
				
				//switch to parent window
				wLib.switchToWindow(driver, "Contacts");
				
				WebElement leadsourceEle = driver.findElement(By.xpath("//select[@name='leadsource']"));
				
				//handle dropdown
				wLib.select(leadsource, leadsourceEle);
				
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
