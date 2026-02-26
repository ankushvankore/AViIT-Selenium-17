package com.TestNGDemos;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D12CreateFriendsData {
    File file;
    FileOutputStream fos;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void createFriendsData(){
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("Ravi");

        cell = row.createCell(1);
        cell.setCellValue("Shinde");

        sheet.createRow(1).createCell(0).setCellValue("Sachin");
        sheet.getRow(1).createCell(1).setCellValue("Patil");

        sheet.createRow(2).createCell(0).setCellValue("Shital");
        sheet.getRow(2).createCell(1).setCellValue("Dorle");

    }

    @BeforeTest
    public void setup() throws FileNotFoundException {
        file = new File("ExcelFiles\\FriendsData.xlsx");
        fos = new FileOutputStream(file);
        wb = new XSSFWorkbook();
        sheet = wb.createSheet();
    }

    @AfterTest
    public void tearDown() throws IOException {
        wb.write(fos);
        wb.close();
        fos.close();
    }
}
