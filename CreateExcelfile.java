import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.*;

public class CreateExcelfile {

	public static void main(String[] args) throws IOException {
		
		// File will override the old file with new file data if the file already exists 
		// If we want write data in file then we have to write " FileOutputStream "
		FileOutputStream file = new FileOutputStream("C:\\Users\\Shubham Dhakan\\DataDrivenTesting\\Data4.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();				// we will not parameterize file in workbook because we creating one
		
		XSSFSheet sheet = workbook.createSheet("DataSet1");		// Creating first data sheet in workbook 
		XSSFSheet sheet2 = workbook.createSheet("DataSet2");	// Creating second data sheet in workbook 
		
		for (int i=0;i<5;i++) 
		{
								XSSFRow row = sheet.createRow(i);		// Creating rows for --> Sheet
								XSSFRow row1 = sheet2.createRow(i);		// Creating rows for --> Sheet2
								
			for (int j=0;j<3;j++) 
			{
								row.createCell(j).setCellValue("Benz");		// Excel Data for --> sheet 
								row1.createCell(j).setCellValue("BMW");		// Exce Data for --> sheet2 
			}
			
		}
		
		workbook.write(file);			// At last we have to parameterize file 
		file.close();					// It will close current file()
		
	}

}
