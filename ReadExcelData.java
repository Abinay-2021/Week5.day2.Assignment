package week5.day2.Assignment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData
{
	
	public static String[][]  readExcelData(String SheetName) throws InvalidFormatException, IOException  
	{
		File fileName=new File("./data/CreateLead2.xlsx");
		XSSFWorkbook wbook = new XSSFWorkbook(fileName);
		XSSFSheet sheet=wbook.getSheet(SheetName);

		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowcount][colcount];
		for (int i = 1; i <=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < colcount; j++) {
				XSSFCell cell = row.getCell(j);

				String value=cell.getStringCellValue();
				System.out.println(value);
				data[i-1][j]=value;
			}
		}
		wbook.close();
		return data;
	}
}