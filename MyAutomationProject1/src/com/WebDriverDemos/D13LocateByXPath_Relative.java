package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D13LocateByXPath_Relative {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        driver.findElement(By.xpath("//div[@class=\"form-section\"]/div[2]/input")).sendKeys("Ila Vashishth");
        //driver.findElement(By.xpath("//input[@placeholder=\"Enter Rediffmail ID\"]")).sendKeys("ila");
        driver.findElement(By.xpath("//input[starts-with(@name, \"login\")]")).sendKeys("ila");
        driver.findElement(By.xpath("//input[@id=\"newpasswd\"]")).sendKeys("ilavashish");
        driver.findElement(By.xpath("//input[@id=\"newpasswd\"]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[14]/div/div/input")).sendKeys("ilavashishth@gmail.com");
    }
}
