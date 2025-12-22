package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D04ReadURL {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String url = driver.getCurrentUrl();

        System.out.println("URL: " + url);

        if(url.contains("dashboard"))
            System.out.println("Login successful");
        else
            System.out.println("Login fail");

        driver.close();
    }
}
