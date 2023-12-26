package com.practicepackage;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KSRTC_CanlenderTest {

	public static void main(String[] args) {
		
		int date = 30;
		//launch browser 
		WebDriver driver = new ChromeDriver();
		
		//maximize window
		driver.manage().window().maximize();
		
		//launch appl
		driver.get("https://www.ksrtc.in/");
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.id("txtJourneyDate")).click();
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='"+date+"']")).click();
		
		
		

	}

}
