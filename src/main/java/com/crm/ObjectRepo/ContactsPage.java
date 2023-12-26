package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	//declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContLookUpImg() {
		return CreateContLookUpImg;
	}
	
	//business lib
	public void clickOnContactlookUpImg()
	{
		CreateContLookUpImg.click();
	}
	
}
