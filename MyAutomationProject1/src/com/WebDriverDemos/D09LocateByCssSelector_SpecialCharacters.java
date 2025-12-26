package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D09LocateByCssSelector_SpecialCharacters {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        //* - Contains (Partial Text)
        WebElement userName = driver.findElement(By.cssSelector("input[placeholder*=\"address\"]"));
        userName.sendKeys("test@gmail.com");
        //$ - Ends with
        WebElement password = driver.findElement(By.cssSelector("input[placeholder$=\"word\"]"));
        password.sendKeys("test@123");
        //^ - Starts with
        WebElement loginBtn = driver.findElement(By.cssSelector("button[id^=\"u_0_5\"]"));
        loginBtn.click();
    }
}
