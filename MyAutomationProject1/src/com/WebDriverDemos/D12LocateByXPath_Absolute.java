package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D12LocateByXPath_Absolute {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys("Ila Vashishth");
        driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div/div[3]/div/input")).sendKeys("ilavashishth");
        driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div/div[6]/div/input")).sendKeys("ila@123");
    }
}
