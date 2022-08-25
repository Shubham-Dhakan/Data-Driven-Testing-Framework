import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.xssf.usermodel.*;				// It will import all XSSF packages

public class Registration { 
	
	public static void main(String[] args) throws IOException {
		
		// WebDriver & ChromeDriver Setup 
		System.setProperty("webdriver.chrome.driver","C:\\\\Web Drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		
		
		// Excel DataSheet Setup
		FileInputStream file = new FileInputStream("C:\\Users\\Shubham Dhakan\\DataDrivenTesting\\Data3.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);			//Opening workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");			// Accessing Sheet 1
		
		int row = sheet.getLastRowNum();		// Saving total no of rows in variable
		
		for (int i=1;i<=row;i++) {					
			XSSFRow current_row = sheet.getRow(i);
			
			String First_Name = current_row.getCell(0).getStringCellValue();
			String Last_Name = current_row.getCell(1).getStringCellValue();
			String Address = current_row.getCell(2).getStringCellValue();
			String Email = current_row.getCell(3).getStringCellValue();
			//String Phone = current_row.getCell(4).getStringCellValue();
			String Languages = current_row.getCell(5).getStringCellValue();
			String Password = current_row.getCell(6).getStringCellValue();
			String Confirm_Password = current_row.getCell(7).getStringCellValue();
			
			// Registration Process 
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(First_Name);
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Last_Name);
			driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']")).sendKeys(Address);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Email);
			//driver.findElement(By.xpath("//input[@type='tel']").sendKeys(Phone);
			driver.findElement(By.xpath("//div[@id='msdd']")).sendKeys(Languages);
			driver.findElement(By.id("firstpassword")).sendKeys(Password);       
			driver.findElement(By.id("secondpassword")).sendKeys(Confirm_Password);
			
		
			// Handling Radio Button 
			WebElement radio_button = driver.findElement(By.xpath("//input[@value='Male']"));
			radio_button.click();
			
			// Handling CheckBoxes
			WebElement check_boxes = driver.findElement(By.id("checkbox1"));
			check_boxes.click();
			
			// Handling Dropdown Element
			WebElement drop_down = driver.findElement(By.id("Skills"));
			Select Skills = new Select(drop_down);
			Skills.selectByVisibleText("Adobe Photoshop");
			
			//WebElement drop_down2 = driver.findElement(By.id("countries"));
			//Select Countries = new Select(drop_down2);
			//Countries.selectByVisibleText("India");
			
			}
			System.out.println("Program is over");
			driver.close();
		}

}


