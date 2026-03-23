package com.WebTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D01FirstTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.40.0");
        System.out.println("Title: " + driver.getTitle());

        driver.close();
    }
}
