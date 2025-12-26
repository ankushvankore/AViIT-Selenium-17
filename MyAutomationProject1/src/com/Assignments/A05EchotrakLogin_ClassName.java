package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A05EchotrakLogin_ClassName {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");

        WebElement userName = driver.findElement(By.className("form-control"));
        userName.sendKeys("Ila_Vashishth");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("ila123");
        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();
    }

}
