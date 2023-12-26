package TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void hardassertTest()
	{
		System.out.println("---step -1 ---");
		System.out.println("---step -2 ---");
		assertEquals("A", "B");
		System.out.println("---step -3 ---");
		System.out.println("---step -4 ---");
	}
	
	@Test
	public void hardassertTest2()
	{
		System.out.println("---step -5 ---");
		System.out.println("---step -6 ---");
		assertNotEquals("x","x");
		System.out.println("---step -7 ---");
		System.out.println("---step -8 ---");
	}
	
	@Test
	public void hardassert3()
	{
		int m=5;
		assertNotNull(m);
		System.out.println("---step -9 ---");
		
	}
	
	
}
