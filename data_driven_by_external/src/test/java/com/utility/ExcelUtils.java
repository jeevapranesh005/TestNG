package com.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils 
{

	@DataProvider(name = "validData" , parallel = true)
	public Object [][] validData() throws IOException
	{
		Object[][] arrObj = ExcelUtils.excelDataProvider();
		
		return new Object[][] {
			arrObj[0]
		};
	}
	
	@DataProvider(name = "invalidData" , parallel = true)
	public Object [][] invalidData() throws IOException
	{
		Object[][] arrObj = ExcelUtils.excelDataProvider();
		
		return new Object[][] {
			arrObj[1] , arrObj[2]
					
		};
	}
	
	public static Object[][] excelDataProvider () throws IOException
	{
		Object[][] arrObj = getExcelData("C:\\Users\\jeeva\\OneDrive\\Desktop\\EXPLEO\\JAVA Selenium\\data_driven_by_external\\src\\test\\resources\\data.xlsx","sheet1");
		
		return arrObj;
	}

	private static Object[][] getExcelData(String file, String sheetName) throws IOException 
	{
		// TODO Auto-generated method stub
		String [][] data = null ;
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook work = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = work.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(0);
			
			int noOfRows = sheet.getPhysicalNumberOfRows();
			
			int noOfCols = row.getLastCellNum();
			
			Cell cell;
			
			data = new String [noOfRows-1][noOfCols];
			
			for (int i = 1 ; i<noOfRows ; i++)
			{
				for (int j = 0 ; j < noOfCols ; j++)
				{
					row = sheet.getRow(i);
					cell = row.getCell(j);
					
					data[i-1][j] = cell.toString();
					
//					System.out.println(data[i-1][j]+ " ");
					
				}
			}
		}
		
		catch (Exception e)
		{
			System.out.println("The exception is : "+e.getMessage());
		}
		
		return data;
		
		
		
	}

	
	
}