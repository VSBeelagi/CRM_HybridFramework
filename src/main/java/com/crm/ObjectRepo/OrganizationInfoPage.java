package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgInfo;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgInfo() {
		return OrgInfo;
	}
	
	public void orgInfo(String OrgName)
	{
		String actual = OrgInfo.getText();
		if (actual.contains(OrgName)) 
		{
			System.out.println("Org created");
		}
		else
		{
			System.out.println("Org not created");
		}
	}

}
