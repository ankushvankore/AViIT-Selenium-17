package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class D15FindMultipleControls {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/?m=1");

        List<WebElement>textBoxes = driver.findElements(By.xpath("//input[@class=\"form-control\"]"));

        for(WebElement tb : textBoxes){
            System.out.println("Text Box says: " + tb.getAttribute("placeholder"));
        }

        driver.close();
    }
}
