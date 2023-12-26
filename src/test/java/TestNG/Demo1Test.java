package TestNG;

import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;

public class Demo1Test extends Baseclass {

	@Test(groups = "regression")
	public void demo1test()
	{
		System.out.println("-- demo1 --");
	}
}
