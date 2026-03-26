package com.StepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S07OHRM_DataDrivenTesting {
    WebDriver driver;

    @Given("Launch OHRM site")
    public void launch_ohrm_site() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("Enter username as {string}")
    public void enter_username_as(String un) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
    }

    @When("Enter password as {string}")
    public void enter_password_as(String ps) {
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
    }

    @When("Click on Login")
    public void click_on_login() {
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    @Then("Dashboard page should open")
    public void dashboard_page_should_open() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

}
