package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D18HandlingRadioButton {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement gnFemale = driver.findElement(By.xpath("//input[@value=\"f\"]"));

        System.out.println("Before...");
        System.out.println("Is Selected: " + gnFemale.isSelected());
        System.out.println("Is Enabled : " + gnFemale.isEnabled());
        System.out.println("Is Visible : " + gnFemale.isDisplayed());

        gnFemale.click();

        System.out.println("After...");
        System.out.println("Is Selected: " + gnFemale.isSelected());
        System.out.println("Is Enabled : " + gnFemale.isEnabled());
        System.out.println("Is Visible : " + gnFemale.isDisplayed());
    }
}
