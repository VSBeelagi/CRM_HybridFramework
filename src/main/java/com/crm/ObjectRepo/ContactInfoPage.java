package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//declare
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactInfo;
	
	//initialize
	public ContactInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//utilize
	public WebElement getContactInfo() {
		return ContactInfo;
	}
	
	public void contactInfo(String lastName)
	{
		String actual = ContactInfo.getText();
		if (actual.contains(lastName)) 
		{
			System.out.println("Contacts created");
		}
		else
		{
			System.out.println("Contacts not created");
		}
	}
}
