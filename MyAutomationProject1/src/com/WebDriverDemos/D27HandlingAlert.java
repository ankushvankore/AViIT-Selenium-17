package com.WebDriverDemos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        alt.accept();           //Will click on Ok button

        WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        js.executeScript("arguments[0].click()", button2);

        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        Thread.sleep(2000);
        alt.accept();

        driver.findElement(By.id("confirmButton")).click();
        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        Thread.sleep(2000);
        alt.dismiss();
        System.out.println(driver.findElement(By.id("confirmResult")).getText());

        driver.findElement(By.id("promtButton")).click();
        alt = driver.switchTo().alert();
        alt.sendKeys("Ila Joshi");
        alt.accept();
        System.out.println(driver.findElement(By.id("promptResult")).getText());

        driver.close();
    }
}
