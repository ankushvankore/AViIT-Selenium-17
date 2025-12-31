package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class D19HandlingDropdownList {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement drpList = driver.findElement(By.id("country"));
        Select countries = new Select(drpList);
        //All the operations on drop down list can be performed via this object of Select class

        System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());

        List<WebElement>countryList = countries.getOptions();
        System.out.println("Total no of Countries: " + countryList.size());

        /*int i = 0;
        for(WebElement c : countryList) {
            System.out.println(i + ". " + c.getText());
            i++;
        }*/

        //countries.selectByVisibleText("United Kingdom");
        //countries.selectByContainsVisibleText("Kingdom");
        //countries.selectByValue("243");
        countries.selectByIndex(239);

        //countries.deselectByIndex(239);

        System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());
    }
}
