package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D03ReadTheTitle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/downloads/");

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        //if(title.equals("Downloads | Selenium"))
        if(title.contains("Selenium"))
            System.out.println("Title match. Test case pass");
        else
            System.out.println("Title not match. Test case fail");

        driver.close();
    }
}
