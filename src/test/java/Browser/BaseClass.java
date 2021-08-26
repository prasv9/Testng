package Browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;
	
	public static void launchUrl(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Testng\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);	
	}
	
	public static WebElement elementLocationById(String id) {
		return driver.findElement(By.id(id));
	}
	
	public static WebElement elementLocatorxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));	
	}
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);	
	}
	public static void buttonClick(WebElement element) {
		element.click();	
	}
	public static void selectionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		
    
	}
	
	public String orderNum(String Loc) {
		WebElement orderno = driver.findElement(By.id(Loc));
		String OrderNumber = orderno.getAttribute("value");
		System.out.println(OrderNumber);
		return OrderNumber;

	}
	public static String excelRead(String path, String sname, int rownum, int cellnum) throws IOException {
		 File f= new File (path);
		 FileInputStream str =new FileInputStream(f);
		 Workbook w = new XSSFWorkbook(str);
	     Sheet sheet = w.getSheet(sname);
	     Row row = sheet.getRow(rownum);
	     Cell cell = row.getCell(cellnum);
	     int cellType = cell.getCellType();
	     String data = null;
	     if (cellType==1) {
	    	data = cell.getStringCellValue();
			
		}
	     else if (DateUtil.isCellDateFormatted(cell)) {
	    	 Date dateCellValue = cell.getDateCellValue();
	    	 SimpleDateFormat fo = new SimpleDateFormat("dd/mm/YYYY");
	    	data=fo.format(dateCellValue);
	     }
	     else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long)numericCellValue;
				data = String.valueOf(l);
			}
			return data;	     
	}
	public String excelWrite(String path, String sname, int rownum, int cellnum, String data) throws IOException {
		
		File f = new File (path);
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);
		Sheet sheet = w.getSheet(sname);
		Row row = sheet.getRow(rownum);
		
		//Sheet createSheet = w.createSheet(sname);
		//Row createRow = createSheet.createRow(rownum);
		Cell createCell = row.createCell(cellnum);
		createCell.setCellValue(data);
		FileOutputStream str = new FileOutputStream(f);
		w.write(str);
		System.out.println("done");
		return data;
	}

}
