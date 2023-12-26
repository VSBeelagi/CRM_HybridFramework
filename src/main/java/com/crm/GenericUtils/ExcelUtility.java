package com.crm.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility{

	/**
	 * This method is used to read data from Excel
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int celNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	
	}
	
	/**
	 * This method is used to write data intio Excel
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).createRow(rowNo).createCell(celNo).setCellValue(data);
	
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method is used to get Last row coutn
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	/**
	 * This method is used to get multiple data from Excel
	 * @param sheetName
	 * @param keyCelNo
	 * @param valueCelNo
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn) throws Throwable
	{
		
		//fetching data from excel
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>(); //empty map
		
		for(int i=1; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
	}
	
	
	public Object[][] getMultipleSetOfData(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		System.out.println(lastRow);
		System.out.println(lastCell);
		Object[][] obj = new Object[lastRow+1][lastCell];
		
		for(int i=0; i<=lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
			obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	
}











