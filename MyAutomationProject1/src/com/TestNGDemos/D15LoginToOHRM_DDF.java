package com.TestNGDemos;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class D15LoginToOHRM_DDF {
    /*
    1. Read the login data from Excel file
    2. Pass this data to test case for login
    3. Update the result (Pass / Fail) and message (User Name if login success)  column with appropriate data
     */
    String fPath = "ExcelFiles\\OHRM_LoginData.xlsx";
    File file;
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    int index = 1;
    String message;

    WebDriver driver;

    @Test (dataProvider = "getLoginData")
    public void loginToOHRM(String un, String ps){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
    }

    @DataProvider
    public Object[][] getLoginData(){
        int rows = sheet.getPhysicalNumberOfRows();
        String[][]data = new String[rows-1][2];

        for(int i = 1; i < rows; i++){
            //row = sheet.getRow(i);
            for(int j = 0; j < 2; j++){
                //cell = row.getCell(j);
                //data[i-1][j] = cell.getStringCellValue();
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                //Data from 2nd row of excel file needs to be stored in 1st row of 2D array
            }
        }
        return  data;
    }

    @AfterMethod
    public void logout(){
        cell = sheet.getRow(index).getCell(2);

        if(driver.getCurrentUrl().contains("dashboard")) {
            message = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();

            driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
            driver.findElement(By.linkText("Logout")).click();
            System.out.println("Test case pass");
            cell.setCellValue("Pass");
            sheet.getRow(index).getCell(3).setCellValue(message);
        }
        else {
            message = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();

            System.out.println("Test case fail");
            cell.setCellValue("Fail");
            sheet.getRow(index).getCell(3).setCellValue(message);
        }

        index++;
    }

    @BeforeTest
    public void setup() throws IOException {
        file = new File(fPath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        fos = new FileOutputStream(file);

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterTest
    public void  tearDown() throws IOException {
        wb.write(fos);
        wb.close();
        fis.close();

        driver.close();
    }
}
