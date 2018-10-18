package com.qa.demosite;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoSite {
	public WebDriver driver = null;
	ExtentReports extent = new ExtentReports(Constants.reportSaveLocation,true);
	ExtentTest test;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void createUserAndLogin() throws InterruptedException, IOException {
		test = extent.startTest("Starting process of making a user and logging in");
		
		driver.get(Constants.url1);
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
		assertEquals("3. Add a User", createUserPage.getPageTitle().getText());
		if(createUserPage.getPageTitle().getText().equals("3. Add a User")) {
			test.log(LogStatus.INFO, "Successfully navigated to the Add a User page");
		}
		
		createUserPage.enterName(Constants.name);
		createUserPage.enterPassword(Constants.password);
		
		assertEquals("The username: " +Constants.name+"\nThe password: "+ Constants.password, createUserPage.getUserPass().getText());
		
		driver.get(Constants.url2);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		assertEquals("4. Login", loginPage.getPageTitle().getText());
		if(loginPage.getPageTitle().getText().equals("4. Login")) {
			test.log(LogStatus.INFO, "Successfully navigated to Login page");
		}
		
		loginPage.enterName(Constants.name);
		loginPage.enterPassword(Constants.password);
		
		assertEquals("**Successful Login**", loginPage.getLoginResult().getText());
		if(loginPage.getLoginResult().getText().equals("**Successful Login**")) {
			test.log(LogStatus.PASS, "Successfully logged in");
		}
		else {
			test.log(LogStatus.FAIL, "Login was unsuccessful");
		}
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

}
