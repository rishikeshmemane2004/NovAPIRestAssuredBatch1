package com.qa.api.gorest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	static Workbook book;
	static Sheet sheet;
	/**
	 * This method reads data from excel file 
	 * 
	 * @param sheetName
	 * @param filePath
	 * @return 2 dimensional Object array
	 */
	public static Object[][] getTestData(String sheetName, String filePath)
	{
		try {
			FileInputStream ip = new FileInputStream(filePath);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++)
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
		
		return data;
	}
	
}
