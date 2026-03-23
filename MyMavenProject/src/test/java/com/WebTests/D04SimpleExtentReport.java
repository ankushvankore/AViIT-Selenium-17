package com.WebTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class D04SimpleExtentReport {
    public static void main(String[] args) throws IOException {
        WebDriver driver;
        ExtentSparkReporter htmlReport = new ExtentSparkReporter("SimpleReport.html");
        //This object represents the HTML file in which we are storing the report
        ExtentReports report = new ExtentReports();
        //This object represents the report
        ExtentTest test;
        //This object represents the test case

        report.attachReporter(htmlReport);
        //Store this report in the said HTML file

        //Set the environment details those will be displayed on the report
        report.setSystemInfo("Application Name", "Google");
        report.setSystemInfo("Operating System", "Windows 10");
        report.setSystemInfo("User Name", "Ila V");
        report.setSystemInfo("Browser", "Chrome");
        report.setSystemInfo("Processor", "I5");

        //Configuration of look and feel of the report
        htmlReport.config().setDocumentTitle("My First Extent Report");
        htmlReport.config().setReportName("Google Report");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setTimeStampFormat("dd-MMM-yyyy");

        test = report.createTest("Google Title Test");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.close();

        test.log(Status.PASS, MarkupHelper.createLabel("Title Test", ExtentColor.GREEN));

        //Create another test
        test = report.createTest("Google Search Test");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Maven", Keys.ENTER);

        //Taking screenshot
        File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(ss, new File("Trial.jpeg"));

        driver.close();

        //Adding the screenshot in Report
        test.log(Status.FAIL, MarkupHelper.createLabel("Search Test", ExtentColor.RED));
        test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("Trial.jpeg").build());


        report.flush();
        //This will create the report file
    }
}
