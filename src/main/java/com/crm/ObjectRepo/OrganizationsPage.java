package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	//declaration
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement OrganizationLookUpImg;
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationLookUpImg() {
		return OrganizationLookUpImg;
	}
	
	//Business Libraries
	public void clickOnLookUpImg()
	{
		OrganizationLookUpImg.click();
	}
}
