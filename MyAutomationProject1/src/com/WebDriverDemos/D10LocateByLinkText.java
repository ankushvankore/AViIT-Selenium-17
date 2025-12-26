package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D10LocateByLinkText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement adLink = driver.findElement(By.linkText("Advertising"));
        String text = adLink.getText();
        System.out.println("Text on the Link: " + text);
        adLink.click();

        /*String url = driver.getCurrentUrl();
        if(url.contains("google-ads"))
            System.out.println("Advertisments page opened");
        else
            System.out.println("Wrong operation");*/
        if(driver.getCurrentUrl().contains("google-ads"))
            System.out.println("Advertisments page opened");
        else
            System.out.println("Wrong operation");
    }
}
