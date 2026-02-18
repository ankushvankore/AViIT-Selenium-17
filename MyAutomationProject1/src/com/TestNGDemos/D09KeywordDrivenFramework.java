package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class D09KeywordDrivenFramework {
    WebDriver driver;
    File file;
    FileInputStream fis;
    Properties prop;

    @Test
    public void automobileTest(){
        driver.findElement(By.linkText(prop.getProperty("autoLinkText"))).click();
        Select makeDD = new Select(driver.findElement(By.id(prop.getProperty("makeID"))));
        makeDD.selectByIndex(3);
        driver.findElement(By.name(prop.getProperty("epName"))).sendKeys("1000");
        driver.findElement(By.xpath(prop.getProperty("domXP"))).sendKeys("02/03/2026");
        new Select(driver.findElement(By.cssSelector(prop.getProperty("seatsCSS")))).selectByIndex(3);
    }

    @BeforeTest
    public void launchBrowser() throws IOException {
        file = new File("src/com/TestNGDemos/MyLocators.properties");
        fis = new FileInputStream(file);
        prop = new Properties();
        prop.load(fis);
        //Will load all the properties from .properties file

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(prop.getProperty("url"));
    }
}
