package com.practicepackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
//		String country="West Indies";
//		String match = driver.findElement(By.xpath("//span[.='"+country+"']/../following-sibling::td[1]")).getText();
//		System.out.println(match);
		String country="dubai";
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
	    boolean flag=false;
		for (WebElement web : teams) 
		{
			String c = web.getText();
			if(c.equalsIgnoreCase(country))
			{
				System.out.println("team is present");
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("country is not present");
		}
	}
}