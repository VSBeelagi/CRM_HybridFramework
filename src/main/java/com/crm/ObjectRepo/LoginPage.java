package com.crm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	//declation
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;
	
	
	//initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}


	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Libraries
	public void login(String USER, String PWD)
	{
		UserNameEdt.sendKeys(USER);
		PasswordEdt.sendKeys(PWD);
		SubmitBtn.click();	
	}
}











