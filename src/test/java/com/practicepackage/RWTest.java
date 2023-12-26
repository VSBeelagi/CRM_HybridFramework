package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RWTest {

public static void main(String[] args) throws Throwable {
		
		//to write the data to property file
				Properties p=new Properties();
				p.setProperty("browser", "chrome");
				p.setProperty("url", "http://localhost:8888");
				p.setProperty("username", "admin");
				p.setProperty("password", "admin");

				//to save the data in property file
				String path="./src/test/resources/cm.properties";
				FileOutputStream fout=new FileOutputStream(path);
				p.store(fout, "write data");

				//to read the data from property file
				FileInputStream fin=new FileInputStream(path);
				p.load(fin);
				String browser = p.getProperty("browser");
				String url = p.getProperty("url");
				String un = p.getProperty("username");
				String pwd = p.getProperty("password");

				System.out.println(browser);
				System.out.println(pwd);

			}
		}

