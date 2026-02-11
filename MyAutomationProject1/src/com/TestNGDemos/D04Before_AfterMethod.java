package com.TestNGDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class D04Before_AfterMethod {
    WebDriver driver;

    @Test(priority = 1)
    public void testFlipkart(){
        driver.get("https://www.flipkart.com/");
    }

    @Test (priority = 3)
    public void testAmazon(){
        driver.get("https://www.amazon.in/");
    }

    @Test (priority = 2)
    public void testMyntra(){
        driver.get("https://www.myntra.com/");
    }

    @Test (priority = 4)
    public void testMeesho(){
        driver.get("https://www.meesho.com/");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void printTitle() throws InterruptedException {
        Thread.sleep(2000);
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
