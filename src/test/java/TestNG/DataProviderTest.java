package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.IPathConstants;

public class DataProviderTest {

	@Test(dataProvider = "dataFromExcel")
	public void getData(String pName, String price, String size)
	{
		System.out.println(pName+"--->"+price+"-->"+size);
	}
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable 
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.getMultipleSetOfData("DP");
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
