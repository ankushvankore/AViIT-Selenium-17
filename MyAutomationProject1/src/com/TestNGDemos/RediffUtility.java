package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffUtility {
    WebDriver driver;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]")
    WebElement fullName;
    @FindBy (id = "newpasswd") WebElement passwordTxtBox;
    @FindBy (css = "select[name^=\"DOB_Day\"]") WebElement dayDD;


    public RediffUtility(WebDriver d){
        driver = d;
        //RedffUtility.driver = D10POMClient.driver;
        PageFactory.initElements(driver, this);
    }

    public void setFullName(String fn){
        //driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]")).sendKeys(fn);
        fullName.sendKeys(fn);
    }

    public void setRediffId(String rediffId){
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[1]/div[3]/div[1]/input[1]")).sendKeys(rediffId);
    }

    public void setPassword(String password){
        //driver.findElement(By.id("newpasswd")).sendKeys(password);
        passwordTxtBox.sendKeys(password);
        driver.findElement(By.id("newpasswd1")).sendKeys(password);
    }

    public void setBirthDate(String day, String month, String year){
        //new Select(driver.findElement(By.cssSelector("select[name^=\"DOB_Day\"]"))).selectByVisibleText(day);
        new Select(dayDD).selectByVisibleText(day);
        new Select(driver.findElement(By.className("middle"))).selectByVisibleText(month);
        new Select(driver.findElement(By.cssSelector("select[name^=\"DOB_Year\"]"))).selectByVisibleText(year);
    }

    public void selectGender(String gender){
        if(gender.equalsIgnoreCase("male"))
            driver.findElement(By.xpath("//input[@value='m']")).click();
        else
            driver.findElement(By.xpath("//input[@value='f']")).click();
    }

    public String checkAvailablity() throws InterruptedException {
        driver.findElement(By.className("btn_checkavail")).click();
        Thread.sleep(5000);
        String message = driver.findElement(By.xpath("//*[@id=\"check_availability\"]")).getText();
        System.out.println(message);

        return message;
    }
}
