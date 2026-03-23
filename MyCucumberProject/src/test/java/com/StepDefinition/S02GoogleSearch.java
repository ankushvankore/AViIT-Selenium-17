package com.StepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S02GoogleSearch {

    WebDriver driver;

    @Given("Open Google In Chrome")
    public void open_google_in_chrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://google.com");
    }

    @When("Enter keyword to search")
    public void enter_keyword_to_search() {
        driver.findElement(By.name("q")).sendKeys("Sara Ali Khan");
    }

    @When("Hit enter")
    public void hit_enter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("A valid search result should display")
    public void a_valid_search_result_should_display() {
        Assert.assertTrue(driver.getCurrentUrl().contains("sara"));
    }
}
