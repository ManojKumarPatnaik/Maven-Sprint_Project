package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class ExcelConfiguration {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String filepath;
	public ExcelConfiguration()
	{
		filepath = System.getProperty("user.dir")+"\\ReadExcelFile\\TestDataSprint.xlsx";
		FileInputStream fis;
		try {
			fis=new FileInputStream(filepath);
			workbook=new XSSFWorkbook(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public String getData(int sheetnumber,int row,int column)
	{
		sheet=workbook.getSheetAt(sheetnumber);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public String getData1(int sheetnumber,int row,int column)
	{
		sheet=workbook.getSheetAt(sheetnumber);
	    int data=(int)sheet.getRow(row).getCell(column).getNumericCellValue();
		return String.valueOf(data);
	}
	public int getRowCount(int sheetindex)
	{
		int rowcount=workbook.getSheetAt(sheetindex).getLastRowNum();
		rowcount=rowcount+1;
		return rowcount;
	}
}
