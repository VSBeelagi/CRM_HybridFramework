package com.Organization_Module;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOfOrgTest {

	public static void main(String[] args) {
		
		//launch the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				//enter the url
				driver.get("http://localhost:8888");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//enter valid UN & PWD
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();

				//click on Org link
				driver.findElement(By.linkText("Organizations")).click();
				
				 List<WebElement> OrgList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
	
				 for(WebElement list:OrgList)
				 {
					String Olist = list.getText();
					System.out.println(Olist);
					System.out.println();
				 }
	
	}
}
