package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class D08Parameterization {
    WebDriver driver;

    @Parameters ({"userName", "password"})
    @Test
    public void login(String un, String ps){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(un);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ps);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
