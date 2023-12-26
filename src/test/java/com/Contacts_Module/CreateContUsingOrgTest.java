package com.Contacts_Module;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContUsingOrgTest {

	public static void main(String[] args) {
		
//		Random ran = new Random();
//		int random = ran.nextInt(500);
		
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
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
		//enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("testyantra11");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//get the confirmation msg
		String OrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
		//validate
		if(OrgInfo.contains("testyantra11"))
		{
			System.out.println("Org is created");
		}
		else
		{
			System.out.println("Org is not created");
		}

		//click on Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("Vijayalaxmi");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String chwind = driver.switchTo().window(win).getTitle();
			if(chwind.contains("Accounts"))
			{
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys("testyantra1");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='testyantra']")).click();
		
		
		Set<String> wi = driver.getWindowHandles();
		Iterator<String> i = wi.iterator();
		while(i.hasNext())
		{
			String wind = i.next();
			String parWind = driver.switchTo().window(wind).getTitle();
			System.out.println(parWind);
			if(parWind.contains("Contacts"))
			{
				break;
			}
			
		}
		
		WebElement leadsource = driver.findElement(By.xpath("//select[@name='leadsource']"));
		
		Select sel = new Select(leadsource);
		sel.selectByVisibleText("Employee");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate the contacts
		String contInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
		System.out.println(contInfo);
		
		//signout
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			
				WebElement signOut = driver.findElement(By.linkText("Sign Out"));
				
				Actions act = new Actions(driver);
				act.moveToElement(signOut).click().perform();
				
				driver.close();
	
	}

}
