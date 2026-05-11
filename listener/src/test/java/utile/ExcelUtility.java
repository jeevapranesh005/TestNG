package utile;

import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility 
{

	@DataProvider(name = "validData" , parallel = true)
	public Object [][] validData() throws IOException
	{
		Object[][] arrObj = ExcelUtility.excelDataProvider("sheet1");
		
		return arrObj;
	}
	
	@DataProvider(name = "invalidData" , parallel = true)
	public Object [][] invalidData() throws IOException
	{
		Object[][] arrObj = ExcelUtility.excelDataProvider("sheet2");
		
		return arrObj;
	}
	
	@DataProvider(name = "valSearch" , parallel = true)
	public Object [][] valSearch() throws IOException
	{
		Object[][] arrObj = ExcelUtility.excelDataProvider("sheet3");
		
		return arrObj;
	}
	
	@DataProvider(name = "inValSearch" , parallel = true)
	public Object [][] inValSearch() throws IOException
	{
		Object[][] arrObj = ExcelUtility.excelDataProvider("sheet4");
		
		return arrObj;
	}
	
	public static Object[][] excelDataProvider (String sheet) throws IOException
	{
		Object[][] arrObj = getExcelData("C:\\Users\\jeeva\\OneDrive\\Desktop\\EXPLEO\\JAVA Selenium\\pratice1\\src\\test\\resources\\Data.xlsx",sheet);
		
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
					
					data[i-1][j] = cell.getStringCellValue();
					
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