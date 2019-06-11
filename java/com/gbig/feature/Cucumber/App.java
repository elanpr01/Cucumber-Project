package com.gbig.feature.Cucumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        data();
    }
    public static HashMap<String, HashMap<String, String>> data() 
	{
		List<HashMap<String, String>> testData = new ArrayList<HashMap<String,String>>();
		HashMap<String, HashMap<String, String>> hm1= new HashMap<String, HashMap<String,String>>();
		
		XSSFWorkbook wb;
		
	try {
		System.out.println("-------------------------test");
		FileInputStream fis= new FileInputStream(new File("src/test/resources/test_Data/TestData.xlsx"));
		 wb=new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet("Sheet1");
		Row Firstrow = sheet.getRow(0);
		Cell currentCell;
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row currentRow = sheet.getRow(i);
			HashMap<String,String> currentHash = new HashMap<String,String>();
			for (int j = 1; j <currentRow.getPhysicalNumberOfCells(); j++) {
				
				 currentCell= currentRow.getCell(j);
				//currentHash.put(Firstrow.getCell(j).getStringCellValue(),currentCell.getStringCellValue());  
				switch (currentCell.getCellType())
				{
				case Cell.CELL_TYPE_STRING:
					System.out.print(currentCell.getStringCellValue() + "\t");

					currentHash.put(Firstrow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
					break;
				}

			}testData.add(currentHash);
			hm1.put(currentRow.getCell(0).getStringCellValue(), currentHash);
		}
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hm1;
}}
