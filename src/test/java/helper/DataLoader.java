package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLoader {

	public static HashMap<String, HashMap<String, String>> data() {
		HashMap<String, HashMap<String, String>> hm1 = new HashMap<String, HashMap<String, String>>();
		XSSFWorkbook wb;
		try {
			System.out.println("----------Data loader---------------");
			FileInputStream fis = new FileInputStream(new File("src/test/resources/test_Data/TestData.xlsx"));
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow Firstrow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 1; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					// currentHash.put(Firstrow.getCell(j).getStringCellValue(),currentCell.getStringCellValue());
					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						currentHash.put(Firstrow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}
				}			
				hm1.put(currentRow.getCell(0).getStringCellValue(), currentHash);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hm1;
	}

	public static HashMap<String, String> data(String TestCase) {
		HashMap<String, String> hm3 = new HashMap<String, String>();
		XSSFWorkbook wb;
		try {
			System.out.println("----------Data loader---------------");
			FileInputStream fis = new FileInputStream(new File("src/test/resources/test_Data/TestData.xlsx"));
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			XSSFRow Firstrow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				for (int j = 1; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(0);
					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						if (currentCell.getStringCellValue().equalsIgnoreCase(TestCase)) {
							hm3.put(Firstrow.getCell(j).getStringCellValue(),
									currentRow.getCell(j).getStringCellValue());
						} else {
							break;
						}
					}
				}
			}
			System.out.println(hm3);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hm3;

	}
}
