package com.Organization_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
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
import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;
import com.crm.GenericUtils.DatabaseUtility;
import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.FileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;
import com.crm.ObjectRepo.CreateOrganizationPage;
import com.crm.ObjectRepo.HomePage;
import com.crm.ObjectRepo.LoginPage;
import com.crm.ObjectRepo.OrganizationInfoPage;
import com.crm.ObjectRepo.OrganizationsPage;

public class CreateOrgWIthAllFileds_POMTest extends Baseclass{
	
	@Test(groups = "smoke")
	public void createOrgWIthAllFileds_POMTest() throws Throwable{
		
		
		//read the data from Excel sheet
		String OrgName = eLib.readDataFromExcel("Organization", 1, 1);
		String typeDD = eLib.readDataFromExcel("Organization", 1, 3);
		String indDD = eLib.readDataFromExcel("Organization", 1, 4);
		
				//click on Org link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnLookUpImg();
				
						
				//enter the mandatory fields
				
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
				cop.createOrg(eLib.getMultipleDataFromExcel("Organization", 0, 1), driver, jLib, indDD, typeDD);
			
							
				//get the confirmation msg
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				oip.orgInfo(OrgName);
				
	}
}
