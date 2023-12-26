package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData51.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		
		int count = sh.getLastRowNum();
		int lastCell = sh.getRow(1).getLastCellNum();
		
		for (int i = 1; i <=count; i++) //row
		{
			
			for (int j = 0; j <lastCell; j++) //cell
			{
				String value =	sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+"  ");
			}
			System.out.println();
		
	}
}}
