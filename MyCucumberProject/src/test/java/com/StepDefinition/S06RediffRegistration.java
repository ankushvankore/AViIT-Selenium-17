package com.StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class S06RediffRegistration {
    WebDriver driver;

    @Given("Launch rediff mail registration page")
    public void launch_rediff_mail_registration_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
    }

    @When("Enter following data for registration")
    public void enter_following_data_for_registration(io.cucumber.datatable.DataTable dataTable) {
        System.out.println(dataTable);
        //List<List<String>>data = dataTable.asLists();
        List<String>data = dataTable.asList();

        System.out.println(data);
        //System.out.println(data.get(0).get(0));

        /*driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.xpath("//input[@placeholder=\"Enter Rediffmail ID\"]")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(data.get(0).get(2));
        driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(data.get(0).get(3));*/
        driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(data.get(0));
        driver.findElement(By.xpath("//input[@placeholder=\"Enter Rediffmail ID\"]")).sendKeys(data.get(1));
        driver.findElement(By.xpath("//input[@id='newpasswd']")).sendKeys(data.get(2));
        driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys(data.get(3));
    }
}
