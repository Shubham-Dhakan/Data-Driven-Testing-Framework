import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadExcelFile2 {

	public static void main(String[] args) throws IOException {
		
	 FileInputStream file1 = new FileInputStream("C:\\Users\\Shubham Dhakan\\DataDrivenTesting\\Data2.xlsx");
	 XSSFWorkbook workbook = new XSSFWorkbook(file1);		// Opening workbook of excel
	 
	 XSSFSheet sheet = workbook.getSheet("Sheet1");			// Accessing Sheet 1
	 int row_count = sheet.getLastRowNum();					// Storing total no of rows 
	 int col_count = sheet.getRow(0).getLastCellNum();		// Storing total no of columns 
	
	 
	 for (int i=0;i<row_count;i++) {	
		 
		 XSSFRow current_row = sheet.getRow(i);				// Storing total number of rows 
		 
		 for (int j=0;j<col_count;j++) {
			 
			 String current_column=current_row.getCell(j).toString();
			 System.out.print("  "+current_column);		// If we will remove "ln" from print 
			 											// then we will get output in table format 
			 
			 //System.out.println(current_column);		// with println we get output in column format	
		 }
		 System.out.println();
	 }
	 
	}

}
