package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelFileDataReading 
{
	public XSSFWorkbook workbook;
	Object data[][]=null;
	@DataProvider(name="TestDataAndConfigs")
	public Object dataRead()
	{
		File file=new File(System.getProperty("user.dir") + "\\TestDataAndConfigs\\InvalidCredentials.xlsx");
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			workbook=new XSSFWorkbook(fileInputStream);
			int rows=workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
			System.out.println(rows);
			int cols=workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
			System.out.println(cols);
			data=new Object[rows-1][cols];
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					data[i-1][j]=workbook.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
