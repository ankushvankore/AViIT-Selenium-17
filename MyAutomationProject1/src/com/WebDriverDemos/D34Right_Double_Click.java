package com.WebDriverDemos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class D34Right_Double_Click {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        Actions act = new Actions(driver);

        WebElement rightClickBtn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
        //act.moveToElement(rightClickBtn).contextClick().perform();
        act.contextClick(rightClickBtn).perform();

        List<WebElement>menus = driver.findElements(By.xpath("//*[@id=\"authentication\"]/ul/li/span"));
        for(WebElement m : menus)
            System.out.println(m.getText());

        //Click somewhere in the blank window so that the earlier menu will get disappeared.
        driver.findElement(By.id("authentication")).click();

        WebElement doubleClickBtn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
        act.moveToElement(doubleClickBtn).doubleClick().perform();

        Alert alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();

        Thread.sleep(2000);
        driver.close();
    }
}
