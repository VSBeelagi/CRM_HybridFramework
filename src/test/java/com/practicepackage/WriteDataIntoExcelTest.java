package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData51.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Organization");
		sh.createRow(11).createCell(0).setCellValue("Qspider");
		sh.getRow(11).createCell(1).setCellValue("Bangalore");
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\TestData51.xlsx");
		wb.write(fout);
		wb.close();
	
	}
}






