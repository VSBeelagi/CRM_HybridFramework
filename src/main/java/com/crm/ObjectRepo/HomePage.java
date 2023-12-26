package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ConatcstsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getConatcstsLink() {
		return ConatcstsLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	//Business LIbraries
	public void clickOnOrgLink()
	{
		OrganizationLink.click();
	}

	public void clickOnContactsLink()
	{
		ConatcstsLink.click();
	}

	public void signOut(WebDriver driver)
	{
		AdministratorImg.click();
		mousehover(driver, SignOut);
		
	}


}












