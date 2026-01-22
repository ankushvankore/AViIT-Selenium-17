package com.WebDriverDemos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class D27HandlingAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/alerts");

        Alert alt;      //Reference of Alert interface
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("window.scrollBy(0, 200)", "");
        WebElement button1 = driver.findElement(By.id("alertButton"));
        js.executeScript("arguments[0].scrollIntoView(true)", button1);
        //driver.findElement(By.id("alertButton")).click();
        button1.click();
        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        Thread.sleep(2000);
        alt.accept();

        WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        js.executeScript("arguments[0].click()", button2);

        Thread.sleep(5000);

        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        Thread.sleep(2000);
        alt.accept();
    }
}
