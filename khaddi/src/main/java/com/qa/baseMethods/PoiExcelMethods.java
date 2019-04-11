package com.qa.baseMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class PoiExcelMethods {
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	String path = null;
	
	
	public void getfile() throws IOException {

		System.out.println(System.getProperty("user.dir"));
		// Giving the path of Ecxel sheet
		//path = "/src.tests.resourses/com.qa.TestsData/khaddiTestdata.xlsx";
		path = System.getProperty("user.dir") + "\\src.tests.resourses\\com\\qa\\TestsData\\khaddiTestdata.xlsx";
		// Read from File
		fis = new FileInputStream(path);

		// Read from workbook
		workbook = new XSSFWorkbook(fis);

		// Read from sheet
		sheet = workbook.getSheetAt(0);
	}
	// Provides total number of rows in sheet - testcase
			public int getSheetRows(String sheetName) {
				int index = workbook.getSheetIndex(sheetName);
				sheet = workbook.getSheetAt(index);
				return (sheet.getLastRowNum() + 1);
			}

			// Provide total number of columns in sheet - testcase
			public int getSheetColumns(String sheetName) {
				int index = workbook.getSheetIndex(sheetName);
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(0);
				return (row.getLastCellNum());
			}
			public String getCellData(String sheetName, String colName, int rowNum) {
				int colNum = -1;
				int index = workbook.getSheetIndex(sheetName);
				sheet = workbook.getSheetAt(index);
				for (int i = 0; i < getSheetColumns(sheetName); i++) {
					row = sheet.getRow(0);
					cell = row.getCell(i);
					if (cell.getStringCellValue().equals(colName)) {
						colNum = cell.getColumnIndex();
						break;
					}
				}
				row = sheet.getRow(rowNum);
				cell = row.getCell(colNum);
				return (cell.getStringCellValue());
			}

			public void setCellData(String sheetName, int colNum, int rowNum, String str) {
				int index = workbook.getSheetIndex(sheetName);
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum);
				cell = row.createCell(colNum);
				cell.setCellValue(str);

				try {
					fileOut = new FileOutputStream(path);
					try {
						workbook.write(fileOut);
						fileOut.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
}
