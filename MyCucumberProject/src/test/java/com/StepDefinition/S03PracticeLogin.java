package com.StepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S03PracticeLogin {
    WebDriver driver;
    @Given("Open practiceTesting site")
    public void open_practice_testing_site() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/login");
    }

    @When("Enter valid Username")
    public void enter_valid_username() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("practice");
    }

    @When("Enter valid Password")
    public void enter_valid_password() {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button[@id='submit-login']")).submit();
    }

    @Then("Logged-in screen should open")
    public void logged_in_screen_should_open() {
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    @When("Enter invalid username")
    public void enter_invalid_username() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("practice1");
    }

    @When("Enter invalid password")
    public void enter_invalid_password() {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("456789");
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//button[@id='submit-login']")).submit();
    }

    @Then("Error message should display")
    public void error_message_should_display() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"flash\"]/b")).getText().contains("invalid"));
    }

}
