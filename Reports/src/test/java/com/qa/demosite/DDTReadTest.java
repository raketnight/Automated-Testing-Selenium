package com.qa.demosite;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DDTReadTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports(Constants.DDTReportLocation);
		test = report.startTest("Commencing Test");
		
	}
	@Test
	public void excelReadTest() throws IOException, InterruptedException{
		ExcelUtiltities excelUtiltities = new ExcelUtiltities();
		excelUtiltities.setExcelFile(Constants.excelLocation+Constants.excelFile, 0);
		XSSFSheet testSheet = excelUtiltities.getExcelWorksheet();
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
