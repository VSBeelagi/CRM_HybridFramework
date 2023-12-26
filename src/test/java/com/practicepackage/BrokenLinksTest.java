package com.practicepackage;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws Throwable {
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//enter URL
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//get all links
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());

		ArrayList<String> link = new ArrayList<String>();// empty array
		
		for(int i=0; i<listlinks.size(); i++)
		{
			String eachlink = listlinks.get(i).getAttribute("href");
			
			URL url = null;
			int statusCode = 0;
		
			try {
		url = new URL(eachlink);
			
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		statusCode = httpConn.getResponseCode();
		
		if(statusCode>=400)
		{
			link.add(eachlink+"---->"+statusCode);
			System.out.println(eachlink+"---->"+statusCode);
		}
			}
		catch (Exception e) 
		{
			link.add(eachlink+"---->"+statusCode);
		}
	
		}
	
	}}
















