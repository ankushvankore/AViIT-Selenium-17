package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D21Synchronization_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();

        if(driver.getCurrentUrl().contains("dashboard")){
            System.out.println("Login succesful");
            Thread.sleep(5000);
            driver.findElement(By.className("bi-caret-down-fill")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Logout")).click();
        }

        driver.close();
    }
}
