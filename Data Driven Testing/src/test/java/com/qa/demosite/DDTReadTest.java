package com.qa.demosite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DDTReadTest {
    WebDriver driver;
    ExtentReports report;
    ExtentTest test,readTest;

    String username;
    String password;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnana\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        report = new ExtentReports(Constants.DDTReportLocation);
        test = report.startTest("Commencing Reading Test");
        readTest = report.startTest("Commencing Writing Test");

    }
    @Test
    public void excelReadTest() throws IOException, InterruptedException{
        CreateUserPage createUserPage = PageFactory.initElements(driver,CreateUserPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        ExcelUtilities excelUtilities = new ExcelUtilities();
        excelUtilities.setExcelFile(Constants.excelLocation+Constants.excelFile, 0);
        XSSFSheet testSheet = excelUtilities.getExcelWorksheet();

        for (int i = 1; i < testSheet.getPhysicalNumberOfRows(); i++) {
            username = excelUtilities.getCellData(i,0);
            password = excelUtilities.getCellData(i,1);

            driver.get(Constants.url1);
            test.log(LogStatus.INFO, "Navigating to the demosite create account page");
            assertEquals("3. Add a User", createUserPage.getPageTitle().getText());
            if(createUserPage.getPageTitle().getText().equals("3. Add a User")) {
                test.log(LogStatus.INFO, "Successfully navigated to the Add a User page");
            }

            test.log(LogStatus.INFO,"Entering username"+i+" for account creation");
            createUserPage.enterName(username);

            test.log(LogStatus.INFO,"Entering password"+i+"for account creation");
            createUserPage.enterPassword(password);

            assertEquals("The username: " +username+"\nThe password: "+ password, createUserPage.getUserPass().getText());

            if (createUserPage.getUserPass().getText().equals("The username: " +username+"\nThe password: "+ password)){
                test.log(LogStatus.PASS,"Succesfully entered username and password"+i);
            }
            else {
                test.log(LogStatus.FAIL,"Could not enter username and pasword"+i);
            }

            driver.get(Constants.url2);
            test.log(LogStatus.INFO,"Navigating to the demosite login page");
            assertEquals("4. Login", loginPage.getPageTitle().getText());
            if(loginPage.getPageTitle().getText().equals("4. Login")) {
                test.log(LogStatus.INFO, "Successfully navigated to Login page");
            }

            test.log(LogStatus.INFO,"Entering username"+i);
            loginPage.enterName(username);

            test.log(LogStatus.INFO,"Entering password"+i);
            loginPage.enterPassword(password);

            assertEquals("**Successful Login**", loginPage.getLoginResult().getText());
            if(loginPage.getLoginResult().getText().equals("**Successful Login**")) {
                test.log(LogStatus.PASS, "Successfully logged in with account"+i);
            }
            else {
                test.log(LogStatus.FAIL, "Login was unsuccessful");
            }

            readTest.log(LogStatus.INFO,"Trying to write in log in attempt of account"+i);
            excelUtilities.setCellData(loginPage.getLoginResult().getText(),i,3);
            if(excelUtilities.getCellData(i,2).equals(excelUtilities.getCellData(i,3))){
                readTest.log(LogStatus.PASS,"Successfully wrote in the file with account"+i+" and matched the expected value in the excel file");
            }

        }

    }

    @After
    public void tearDown() {
        driver.quit();
        report.flush();
    }
}
