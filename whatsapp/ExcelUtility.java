package com.mindforce.whatsapp;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
		static String filePath = "C:\\Users\\Lenovo\\student phone number.xlsx";
	
		public static String getData() throws Exception {
	        StringBuilder sb = new StringBuilder();
	        FileInputStream fis = null;
	        Workbook workbook = null;
	        
	        try
	        {
	        	fis = new FileInputStream(filePath);
	            workbook = new XSSFWorkbook(fis);
	        	Sheet sheet = workbook.getSheet("Sheet1");
	        	
	        	for (int i=1; i<=sheet.getLastRowNum(); i++) {
	                sb.append(sheet.getRow(i).getCell(1).getStringCellValue());
	                if (i%10==0)
	                	sb.append("----------");
	                else if (i != sheet.getLastRowNum())
	                	sb.append("\n");
	            }
	            
	            workbook.close();
	            return sb.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	        	if (workbook != null) workbook.close();
	        }
	    }
	}

	


