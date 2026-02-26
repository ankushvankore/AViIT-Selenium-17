package com.TestNGDemos;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D13CreateLoginData {
    String fPath = "ExcelFiles\\OHRM_LoginData.xlsx";
    File file;
    FileOutputStream fos;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    int index = 0;
    @Test (dataProvider = "getLoginData")
    public void createLoginData(String un, String ps){
        row = sheet.createRow(index);
        cell = row.createCell(0);
        cell.setCellValue(un);

        cell = row.createCell(1);
        cell.setCellValue(ps);

        cell = row.createCell(2);
        cell.setCellValue("Not Run");

        index++;
    }

    @DataProvider
    public Object[][] getLoginData(){
        String[][] data = new String[][]{
                new String[] {"admin", "admin123"},
                new String[] {"ila", "ila123"},
                new String[] {"admin", "admin123"},
                new String[] {"parth", "parth123"}
        } ;

        return data;
    }

    @BeforeTest
    public void setup() throws FileNotFoundException {
        file = new File(fPath);
        fos = new FileOutputStream(file);
        wb = new XSSFWorkbook();
        sheet = wb.createSheet("Login Data");

        sheet.createRow(index).createCell(0).setCellValue("User Name");
        sheet.getRow(index).createCell(1).setCellValue("Password");
        sheet.getRow(index).createCell(2).setCellValue("Result");

        index++;
    }

    @AfterTest
    public void tearDown() throws IOException {
        wb.write(fos);
        wb.close();
        fos.close();
    }
}
