package TestNG;

import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;

public class Sample1Test extends Baseclass {

	@Test(groups = "smoke")
	public void sample1test()
	{
		System.out.println("-- sample1 --");
	}
	
	@Test(groups = "regression")
	public void sample2Test()
	{
		System.out.println("-- simple1 --");
	}
}
