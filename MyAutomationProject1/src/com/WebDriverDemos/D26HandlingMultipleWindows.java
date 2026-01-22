package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class D26HandlingMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.naukri.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 400)", "");
        //Thread.sleep(2000);
        WebElement remote = driver.findElement(By.xpath("//span[text()=\"Remote\"]"));
        js.executeScript("arguments[0].click()", remote);
        System.out.println("Title: " + driver.getTitle());

        Set<String>windows = driver.getWindowHandles();
        System.out.println(windows);

        /*Object[] winArray = windows.toArray();
        String win1 = winArray[0].toString();       //id of 1st window
        String win2 = winArray[1].toString();       //id of 2nd window
         */
        Iterator<String>itr = windows.iterator();
        //Iterator is an interface for iterating (reading) the values from Set<>
        String win1 = itr.next();   //Will read 1st element i.e. id of 1st window
        String win2 = itr.next();   //Will read 2nd element i.e. id of 2nd window

        driver.switchTo().window(win2);
        Thread.sleep(5000);
        System.out.println("Title: " + driver.getTitle());

        js.executeScript("window.scrollBy(0, 100)", "");
        WebElement chkBox = driver.findElement(By.xpath("//*[@id=\"search-result-container\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/label/i"));
        js.executeScript("arguments[0].click()", chkBox);

        Thread.sleep(2000);

        driver.switchTo().window(win1);

        driver.findElement(By.linkText("Login")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
