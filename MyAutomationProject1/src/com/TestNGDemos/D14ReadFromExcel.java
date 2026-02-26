package com.TestNGDemos;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D14ReadFromExcel {
    String fPath = "ExcelFiles\\OHRM_LoginData.xlsx";
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test(enabled = false)
    public void readData(){
        row = sheet.getRow(0);
        cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());

        System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
        System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
    }

    @Test
    public void readAllData(){
        int rows = sheet.getPhysicalNumberOfRows();
        int cells = sheet.getRow(0).getPhysicalNumberOfCells();
        for(int i = 0; i < rows; i++){
            row = sheet.getRow(i);
            for(int j = 0; j < cells; j++){
                cell = row.getCell(j);
                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }
    }

    @BeforeTest
    public void setup() throws IOException {
        file = new File(fPath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        //As we are not creating new workbook rather we are reading the data from existing
        //workbook
        sheet = wb.getSheet("Login Data");
    }

    @AfterTest
    public void teadDown() throws IOException {
        wb.close();
        fis.close();
    }
}
