package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void softassertTest()
	{
		String exp = "vtiger CRM 5 - Commercial Open Sour";
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		String actual = driver.getTitle();
		System.out.println(actual);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, exp);
		System.out.println("-- appl launched");
		System.out.println("-- execution ends");
		sa.assertAll();
	}
}
