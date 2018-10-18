package com.qa.wait;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WaitTest {
	public WebDriver driver = null;
	ExtentReports extent = new ExtentReports(Constants.reportPath,true);
	ExtentTest test;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.chromePath);
		driver = new ChromeDriver();
	}
	
	@Test
	public void waitTest() {
		test = extent.startTest("Going to QA page");
		driver.get(Constants.url);
		
		test.log(LogStatus.INFO, "Loaded onto the QA page");
		QAShafeeqPage qaShafeeqPage = PageFactory.initElements(driver, QAShafeeqPage.class);
		
		assertEquals("I HATE YOU!\n-The Shafeeq",qaShafeeqPage.getElement(driver).getText());
		
		if(qaShafeeqPage.getElement(driver).getText().equals("I HATE YOU!\n-The Shafeeq")) {
			test.log(LogStatus.PASS, "Successfully waited and the expected message appeared");
		}
		else {
			test.log(LogStatus.FAIL, "Waited and the expected message did not appear");
		}
	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}
}
