package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	private static Workbook book;
	private static Sheet sheet;
	
	/**
	 *  1 i maintain my path giving path of my sheet and where exactly its available
	 *  with the rrot directory . 
	 *  then creating method to get data
	 *  then creating object of the file input stream class
	 *  then passing into it path name
	 *  then creating woorkbookfactory class this class is responsible to get the sheet
	 *  and we passing sheet name
	 *  this sheetname returning sheet reference then we are creating sheet reference name 
	 *  iporting from poi ss usermodel 
	 *  then we starting to pick the data fro  excel file 
	 *  in excel data available in the form of rows and columns
	 *  columns most of the time is constant but row is dynamic
	 *  because of the we are gonna use two dimension object array
	 *  creating object two dim array class
	 *  once we created object of it its throwing error and asking to provide with data so below example 
	 *  			Object dataExcel[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 *  added data why added like that because its dynamic so later on if row or column number 
	 *  will changed its not  gonna throw any error it will pick the latest data 
	 *  up to this point data structure is created 
	 *  now startting to fill the data using inner and outher for loop 
	 *  inner loop for column 
	 *  outher loop for rows 
	 *  
	 *  in line number 67 i wrote +1 its because i dont need my column name in my 
	 *  test script then it will start from actual data then converting it to string so it will be 
	 *  stored in string 
	 *  
	 *  two dimension object array is java array colletion 
	 *  
	 *  
	 * 
	 */
	
	
	
	private static String Test_Data_Sheet_Path = "./src/main/java/com/qa/hubspot/testdata/HubSpot_testData.xlsx";
	
	
	public static Object[][] getTestData(String sheetName) {
		
		Object dataExcel[][] = null;
		
	
		try {
			FileInputStream inp = new FileInputStream(Test_Data_Sheet_Path);
		    book = WorkbookFactory.create(inp);
		    sheet = book.getSheet(sheetName);
			
		    dataExcel = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					
					
					dataExcel[i][j] = sheet.getRow(i+1).getCell(j).toString();
					
				}
			}
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		return dataExcel;
		
		 
	}
	
	
	
	
	
	
	
	
	
	

}
