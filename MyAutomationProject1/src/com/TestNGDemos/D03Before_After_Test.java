package com.TestNGDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class D03Before_After_Test {
    WebDriver driver;

    @Test (priority = 1)
    public void testFlipkart(){
        driver.get("https://www.flipkart.com/");
        System.out.println("Title: " + driver.getTitle());
    }

    @Test (priority = 3)
    public void testAmazon(){
        driver.get("https://www.amazon.in/");
        System.out.println("Title: " + driver.getTitle());
    }

    @Test (priority = 2)
    public void testMyntra(){
        driver.get("https://www.myntra.com/");
        System.out.println("Title: " + driver.getTitle());
    }

    @Test (priority = 4)
    public void testMeesho(){
        driver.get("https://www.meesho.com/");
        System.out.println("Title: " + driver.getTitle());
    }

    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
