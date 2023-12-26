package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {

	@Test(dependsOnMethods = "demo")
	public void sample()
	{
		System.out.println("-- TEstscript --1 --");
	}
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("-- Connect to DB");
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("-- launch the browser --");
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("-- Login to Application --");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("-- LOgout from Application");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("-- Disconnect from DB --");
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("-- close the browser --");
	}
	
	@Test
	public void demo()
	{
		System.out.println("--TEstscript -2 --");
	}
	
	@BeforeClass
	public void bc2()
	{
		System.out.println("--BC 2-- ");
	}
	
	@AfterClass
	public void AC2()
	{
		System.out.println("--AC 2 --");
	}
}


















