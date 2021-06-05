package com.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteResultsToExcel {


	private static XSSFWorkbook workbook;

	public static String writeData(String productName)
	{
		String fileName = DateUtil.getTimeStamp() + ".xlsx";
		workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("petco RDP exam Result");
        sheet.setColumnWidth(0, 80*256);
        sheet.setColumnWidth(1, 50*256);
        Row headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("Product Title");  
        
        sheet.createRow(1).createCell(0).setCellValue(productName);

        
        try {
			FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+"/test-output-excel/"+fileName);
			workbook.write(fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return fileName;
	}
	
}
