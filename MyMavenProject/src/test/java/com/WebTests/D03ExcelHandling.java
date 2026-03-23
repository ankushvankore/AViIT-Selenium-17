package com.WebTests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class D03ExcelHandling {
    /*
    For excel handling you are supposed to add two dependencies
    1. Apache POI
    2. Apache POI OOXML
     */
    String fPath = "D:\\AViIT\\Demos\\Selenium_17\\OHRM Assignment_Data.xlsx";
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFCell cell;

    @BeforeTest
    public void setup() throws IOException {
        file = new File(fPath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
    }

    @Test
    public void getData(){
        int rows = sheet.getPhysicalNumberOfRows();
        int cells = sheet.getRow(0).getPhysicalNumberOfCells();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cells; j++){
                cell = sheet.getRow(i).getCell(j);

                switch(cell.getCellType())
                {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
            System.out.println();
        }
    }

    @AfterTest
    public void tearDown() throws IOException {
        wb.close();
        fis.close();
    }
}
