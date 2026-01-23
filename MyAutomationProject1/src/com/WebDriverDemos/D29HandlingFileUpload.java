package com.WebDriverDemos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D29HandlingFileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("Ila");
        driver.findElement(By.id("lastName")).sendKeys("Joshi");
        driver.findElement(By.id("userEmail")).sendKeys("ila@gmail.com");
        WebElement gnFemale = driver.findElement(By.id("gender-radio-2"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", gnFemale);
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "A");
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("01 Nov 2000", Keys.ENTER);

        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Dell\\Downloads\\WhatsApp Image 2025-12-13 at 3.57.29 PM.jpeg");
    }
}
