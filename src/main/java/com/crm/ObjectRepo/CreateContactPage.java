package com.crm.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtils.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{

	//declaration
	@FindBy(name= "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookUpimg;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadSourceDD;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearchText;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpimg() {
		return OrgLookUpimg;
	}

	public WebElement getLeadSourceDD() {
		return leadSourceDD;
	}

	public WebElement getOrgSearchText() {
		return OrgSearchText;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Libraries
	public void createContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		SaveBtn.click();
	}
	
	public void createContact(String lastName, String lead)
	{
		lastNameEdt.sendKeys(lastName);
		select(lead, leadSourceDD);
		SaveBtn.click();
	}
	
	public void createContact(String lastName, WebDriver driver, String OrgName, String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		OrgLookUpimg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchText.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		select(leadSource, leadSourceDD);
		SaveBtn.click();
		
	}
		
}





