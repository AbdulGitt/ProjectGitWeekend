package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		 return driver=new ChromeDriver();
	}
	
	
	public static WebDriver browserLaunch(String bname) {		
		switch(bname) {		
		case "chrome":
				WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
		break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser");		
		
		}
		return driver;

	}
	
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void implicitlywait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;		
	}
	
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void movetoElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();

	}
	
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static void screenshot(String name) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\abdul\\eclipse-workspace\\Photon\\Mavenn\\src\\test\\resources\\Screenshot\\"+name+".png");
		FileUtils.copyFile(src, des);

	}
	
	
//	public static String excelRead(String name,String sheet,int row,int cellno) throws IOException {
//		
//		File f=new File("C:\\Users\\abdul\\eclipse-workspace\\Photon\\Mavenn\\src\\test\\resources\\"+name+".xlsx");
//		FileInputStream fi=new FileInputStream(f);		
//		Workbook w=new XSSFWorkbook(fi);
//		Sheet s = w.getSheet(sheet);
//		Row r = s.getRow(row);
//		Cell cell = r.getCell(cellno);
//		int cellType = cell.getCellType();
//		String value=null;
//		if(cellType==1) {
//			 value = cell.getStringCellValue();
//		}
//		else {
//			if(DateUtil.isCellDateFormatted(cell)) {
//				Date dc = cell.getDateCellValue();
//				SimpleDateFormat sd=new SimpleDateFormat("DD-MM-YYYY");
//				 value = sd.format(dc);
//			}
//			else {
//				double nc = cell.getNumericCellValue();				
//				long l=(long)nc;				
//				 value = String.valueOf(l);				
//			}
//		}
//		return value;
//
//	}
//	
	

}
