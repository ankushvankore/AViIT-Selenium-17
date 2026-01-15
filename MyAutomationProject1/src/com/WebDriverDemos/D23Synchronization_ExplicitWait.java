package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class D23Synchronization_ExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://omayo.blogspot.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement chkBox = driver.findElement(By.id("dte"));

        driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();

        System.out.println("Before....");
        System.out.println("Enabled : " + chkBox.isEnabled());
        System.out.println("Selected: " + chkBox.isSelected());

        //wait.until(ExpectedConditions.elementToBeClickable(chkBox));
        //chkBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(chkBox)).click();

        System.out.println("After....");
        System.out.println("Enabled : " + chkBox.isEnabled());
        System.out.println("Selected: " + chkBox.isSelected());
    }
}
