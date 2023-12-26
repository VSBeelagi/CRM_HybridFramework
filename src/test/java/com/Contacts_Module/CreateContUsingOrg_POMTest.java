package com.Contacts_Module;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;
import com.crm.GenericUtils.DatabaseUtility;
import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.FileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;
import com.crm.ObjectRepo.ContactInfoPage;
import com.crm.ObjectRepo.ContactsPage;
import com.crm.ObjectRepo.CreateContactPage;
import com.crm.ObjectRepo.CreateOrganizationPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.LoginPage;
import com.crm.ObjectRepo.OrganizationInfoPage;
import com.crm.ObjectRepo.OrganizationsPage;

public class CreateContUsingOrg_POMTest extends Baseclass{

	@Test(groups = "smoke")
	public void createContUsingOrg_POMTest() throws Throwable{

		
//		//create object for all utility classes
//		DatabaseUtility dLib = new DatabaseUtility();
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//
//		
//		//fetch the common data using property file
//		String BROWSER = fLib.readDataFromPropetyFile("browser");
//		String URL = fLib.readDataFromPropetyFile("url");
//		String USERNAME = fLib.readDataFromPropetyFile("username");
//		String PASSWORD = fLib.readDataFromPropetyFile("password");
		
		//read the data from Excel sheet
		String typeDD = eLib.readDataFromExcel("Organization", 1, 3);
		String indDD = eLib.readDataFromExcel("Organization", 1, 4);
		String lastName = eLib.readDataFromExcel("Contacts", 1, 0);
		String ld = eLib.readDataFromExcel("Contacts", 1, 1);
		String OrgName = eLib.readDataFromExcel("Organization", 1, 1);
		//launch the browser
		
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else {
//			System.out.println("invalid browser");
//		}
//		
//		wLib.maximizeWindow(driver);
//		
//				
//				//enter the url
//				driver.get(URL);
//			
//				wLib.waitForPageLoad(driver);
//				
//				//enter valid UN & PWD
//				LoginPage lp = new LoginPage(driver);
//				lp.login(USERNAME, PASSWORD);

				//click on Org link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();

				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnLookUpImg();
				
		
			
				//enter the mandatory fields
				
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
				cop.createOrg(eLib.getMultipleDataFromExcel("Organization", 0, 1), driver, jLib, indDD, typeDD);			
				
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				oip.orgInfo(OrgName);
				
				hp.clickOnContactsLink();
				
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnContactlookUpImg();
				
				CreateContactPage ccp = new CreateContactPage(driver);
				ccp.createContact(lastName, driver, OrgName, ld);
//				
//				
				//get the confirmation msg
				
				ContactInfoPage cip = new ContactInfoPage(driver);
				cip.contactInfo(lastName);
				
				
					//signout
				
//				hp.signOut(driver);
					
				
					

	}

}
