package TestNG;

import org.testng.annotations.Test;

import com.crm.GenericUtils.Baseclass;

public class Simple1Test extends Baseclass{

	@Test(groups = "regression")
	public void simple1Test()
	{
		System.out.println("-- simple1 --");
	}
}
