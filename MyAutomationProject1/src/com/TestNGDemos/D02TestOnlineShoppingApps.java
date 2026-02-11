package com.TestNGDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class D02TestOnlineShoppingApps {
    @Test (priority = 1)
    public void testFlipkart(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.flipkart.com/");
        System.out.println("Title: " + driver.getTitle());

        driver.close();
    }

    @Test (priority = 3)
    public void testAmazon(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.in/");
        System.out.println("Title: " + driver.getTitle());

        driver.close();
    }

    @Test (priority = 2)
    public void testMyntra(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.myntra.com/");
        System.out.println("Title: " + driver.getTitle());

        driver.close();
    }

    @Test (priority = 4)
    public void testMeesho(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.meesho.com/");
        System.out.println("Title: " + driver.getTitle());

        driver.close();
    }
}
