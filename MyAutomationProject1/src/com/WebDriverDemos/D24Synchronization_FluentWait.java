package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class D24Synchronization_FluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        FluentWait<WebDriver>wait = new FluentWait<>(driver);

        wait.withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();

        if(driver.getCurrentUrl().contains("dashboard")){
            System.out.println("Login succesful");
            driver.findElement(By.className("bi-caret-down-fill")).click();
            driver.findElement(By.linkText("Logout")).click();
        }

        driver.close();
    }
}
