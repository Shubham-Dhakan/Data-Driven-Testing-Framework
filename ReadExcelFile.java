import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\Shubham Dhakan\\DataDrivenTesting\\data1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//XSSFSheet sheet = workbook.getSheet("Sheet1");	// this exactly calling the sheet by its name
		XSSFSheet sheet = workbook.getSheetAt(0);			// calling sheet by index number 
		
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for (int i=0;i<rowcount;i++) {
			XSSFRow current_row=sheet.getRow(i);
			
			for (int j=0;j<colcount;j++) {
				
				String current_col=current_row.getCell(j).toString();
				System.out.print(" "+current_col);
			}
			System.out.println();
		}

		
	}

}
