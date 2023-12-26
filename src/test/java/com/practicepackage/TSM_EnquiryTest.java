package com.practicepackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TSM_EnquiryTest {

	


		public static void main(String[] args) throws Throwable {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
			driver.findElement(By.xpath("//a[normalize-space(text())='Enquiry']")).click();
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='fname']")).sendKeys("ABBC");
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='email']")).sendKeys("Abcde@gmail.com");
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='mobileno']")).sendKeys("9874563210");
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='subject']")).sendKeys("Regarding package");
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::textarea[@name='description']")).sendKeys("Need more offers to the packages");
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::button[@name='submit1']")).click();
			driver.findElement(By.linkText("Admin Login")).click();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
			driver.findElement(By.xpath("//input[@name='login']")).click();
			driver.findElement(By.xpath("//span[text()='Manage Enquiries']")).click();
			driver.findElement(By.xpath("//span[@class='fa fa-bars']")).click();
//			 List<WebElement> alle = driver.findElements(By.xpath("//tbody/tr[last()]/td[4]/span"));
	String mail = driver.findElement(By.xpath("//tbody/tr[last()]/td[4]/span")).getText();
			System.out.println(mail );
	Thread.sleep(2000);
//			 System.out.print(alle.size());
//			for(WebElement e:alle)
//			{
//				System.out.println(e.getText());
//				Actions act = new Actions(driver);
//				act.scrollToElement(e).perform();
//			}
		driver.close();
		}
	}


