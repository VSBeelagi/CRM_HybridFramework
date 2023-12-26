package com.crm.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{

	//declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "website")
	private WebElement WebsiteEdt;
	
	@FindBy(name = "tickersymbol")
	private WebElement tickersymbol;
	
	@FindBy(name = "phone")
	private WebElement PhoneNumEdt;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDD;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement TypeDD;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	//initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getWebsiteEdt() {
		return WebsiteEdt;
	}

	public WebElement getTickersymbol() {
		return tickersymbol;
	}

	public WebElement getPhoneNumEdt() {
		return PhoneNumEdt;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Libraries
	public void createOrg(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	
	public void createOrg(HashMap<String, String> map, WebDriver driver, JavaUtility j)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			if(s.getKey().contains("accountname"))
			{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+j.getRandomNo());
			}
			else
			{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}
		
		SaveBtn.click();
	}
	
	public void createOrg(HashMap<String, String> map, WebDriver driver, JavaUtility j, String ind, String type)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			if(s.getKey().contains("accountname"))
			{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+j.getRandomNo());
			}
			else
			{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}
	select(ind, IndustryDD);
	select(type, TypeDD);
	SaveBtn.click();
}}













