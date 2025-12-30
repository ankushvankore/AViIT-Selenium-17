package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D17HandlingCheckBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement chkBox = driver.findElement(By.xpath("//div[@class=\"form-section\"]/div[15]/div/input"));

        System.out.println("Before...");
        System.out.println("Is Selected: " + chkBox.isSelected());
        System.out.println("Is Enabled : " + chkBox.isEnabled());
        System.out.println("Is Visible : " + chkBox.isDisplayed());

        if(!chkBox.isSelected())
            chkBox.click();

        System.out.println("After...");
        System.out.println("Is Selected: " + chkBox.isSelected());
        System.out.println("Is Enabled : " + chkBox.isEnabled());
        System.out.println("Is Visible : " + chkBox.isDisplayed());
    }
}
