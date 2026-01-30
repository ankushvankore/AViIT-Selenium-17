package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class D33HoverTheMouse {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/?m=1");

        Actions act = new Actions(driver);

        WebElement btn = driver.findElement(By.className("dropbtn"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", btn);

        act.moveToElement(btn).perform();

        List<WebElement>menus = driver.findElements(By.xpath("//div[@class=\"dropdown-content\"]/a"));
        for (WebElement m : menus)
            System.out.println(m.getText());

        Thread.sleep(2000);
        driver.close();
    }
}
