package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D37HandlingShadowDOM {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/?m=1");

        //WebElement shadowParent = driver.findElement(By.id("shadow_host"));
        //SearchContext ss = shadowParent.getShadowRoot();
        SearchContext ss = driver.findElement(By.id("shadow_host")).getShadowRoot();
        ss.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("Ila Vashishth");
    }
}
