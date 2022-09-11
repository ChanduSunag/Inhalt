package com.crm.myriad.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it's developed by using Apache POI libraries, Which is used to handle Microsoft Excel File
 * @author Chandan
 */

public class ExcelLibrary implements IConstantLibrary {

	/**
	 * it's used to read the data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable
	 */

	public String getStringDataFromExcel(String sheetName , int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis  = new FileInputStream(EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	
	/**
	 * it's used to read the data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable
	 */

	public double getNumericDataFromExcel(String sheetName , int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis  = new FileInputStream(EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		double data = row.getCell(cellNum).getNumericCellValue();
		wb.close();
		return data;
	}	


	/**
	 * it's used to get the data from last used row number on Specified Sheet
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */

	public int getRowCount(String sheetName) throws Throwable 
	{
		FileInputStream fis  = new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}


	/**
	 * it's used to write the data back to Excel File
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */

	public void setDataExcel(String sheetName , int rowNum, int cellNum ,String data) throws Throwable
	{
		FileInputStream fis  = new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();

	}

}


