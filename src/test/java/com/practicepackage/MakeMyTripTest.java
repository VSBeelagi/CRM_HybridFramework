package com.practicepackage;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest {

	public static void main(String[] args) throws Throwable {
		
		String monthAndYear = "March 2024";
		int date = 28;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
		Thread.sleep(3000);
		act.moveByOffset(0, 80).click().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		String actual = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextArrow = "//span[@aria-label='Next Month']";
		
		for(;;)
		{
			try 
			{
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
	}
}
