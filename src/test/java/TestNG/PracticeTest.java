package TestNG;

import org.testng.annotations.Test;

public class PracticeTest {

	@Test()
	public void createTest()
	{
		int[]x = {1,2,3};
		System.out.println(x[5]);
		System.out.println("--- data Created ----");
	}
	
	@Test
	public void editTest()
	{
		System.out.println("-- data modification is done --");
	}
	
	@Test(priority = 2, invocationCount = -1)
	public void deleteTest()
	{
		System.out.println("--- data deleted successfully ---");
	}
}
