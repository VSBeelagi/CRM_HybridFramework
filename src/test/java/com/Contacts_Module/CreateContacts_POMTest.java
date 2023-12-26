package com.Contacts_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;
import com.crm.ObjectRepo.ContactInfoPage;
import com.crm.ObjectRepo.ContactsPage;
import com.crm.ObjectRepo.CreateContactPage;
import com.crm.ObjectRepo.HomePage;

public class CreateContacts_POMTest extends Baseclass{

	@Test
	public void createContacts_POMTest() throws Throwable
	{
	//data fetching from excel
			String lastName = eLib.readDataFromExcel("Contacts", 1, 0)+jLib.getRandomNo();
			String leadsource = eLib.readDataFromExcel("Contacts", 1, 1);
	
			
			//click on Contacts link
			HomePage hp = new HomePage(driver);
			hp.clickOnContactsLink();
			
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnContactlookUpImg();
//					driver.findElement(By.linkText("Contacts")).click();
//					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createContact(lastName, leadsource);
			
			Assert.fail();
//			driver.findElement(By.name("lastname")).sendKeys(lastName);
//					
//					WebElement leadsourceEle = driver.findElement(By.xpath("//select[@name='leadsource']"));
//					
//					wLib.select(leadsource, leadsourceEle);
//					Select sel = new Select(leadsource);
//					sel.selectByVisibleText("Employee");
//					
//					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
					//validate the contacts
			ContactInfoPage cip = new ContactInfoPage(driver);
			cip.contactInfo(lastName);
//					String contInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//				
//					System.out.println(contInfo);
					
					//signout
//							driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//						
//							WebElement signOut = driver.findElement(By.linkText("Sign Out"));
//							
//							wLib.mousehover(driver, signOut);
//							
//							driver.quit();
	}
//			@Test
//			public void demo()
//			{
//				System.out.println("-- Regional regression");
//			}
//
//			@Test
//			public void sample()
//			{
//				System.out.println("-- sample --");
//			}
	
}
