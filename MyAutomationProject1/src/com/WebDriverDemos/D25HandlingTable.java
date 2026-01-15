package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class D25HandlingTable {
    /*
    1. Display all headers
    2. Display total no of rows
    3. Display any row randomly
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");

        //List<WebElement>headers = driver.findElements(By.tagName("th"));
        List<WebElement>headers = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/thead/tr/th"));

        for(WebElement h : headers)
            System.out.println(h.getText());

        List<WebElement>rows = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr"));
        System.out.println("Total rows: " + rows.size());

        Random rnd = new Random();
        int i = rnd.nextInt(rows.size());

        System.out.println(rows.get(i).getText());
        System.out.println(driver.findElement(By.xpath("//table[@class=\"dataTable\"]/tbody/tr["+(i+1)+"]")).getText());

        driver.close();
    }
}
