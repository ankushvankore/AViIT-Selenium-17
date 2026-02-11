package com.TestNGDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class D01FirstTest {
    @Test
    public void myFirstTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.close();
    }

    public void trial(){
        System.out.println("This is trial method");
    }
}
