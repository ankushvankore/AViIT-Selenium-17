package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class D05SeleniumAssignment {
    WebDriver driver;

    @BeforeTest (alwaysRun = true)
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod(alwaysRun = true)
    public void launchSelenium(){
        driver.get("https://www.selenium.dev/");
        System.out.println("Title: "+driver.getTitle());
    }

    @Test (groups = "CoreFunctionality")
    public void downloadsLink(){
        driver.findElement(By.linkText("Downloads")).click();
    }

    @Test (groups = "CoreFunctionality")
    public void documentationLink(){
        driver.findElement(By.linkText("Documentation")).click();
    }

    @Test (groups = "MiscFunctionality")
    public void supportLink(){
        driver.findElement(By.linkText("Support")).click();
    }

    @Test (groups = "MiscFunctionality")
    public void projectsLink(){
        driver.findElement(By.linkText("Projects")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void getTitle(){
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
