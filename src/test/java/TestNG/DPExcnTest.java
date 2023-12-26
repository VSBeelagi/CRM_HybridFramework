package TestNG;

import org.testng.annotations.Test;

public class DPExcnTest {

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	public void getData(String pName, String price, String size)
	{
		System.out.println(pName+"-->"+price+"--->"+size);
	}
}
