package com.StepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S01GoogleTitle {
    WebDriver driver;
    String title;

    @Given("Open Google")
    public void open_google() {
        System.out.println("Launching Google");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://google.com");
    }

    @When("Capture title of Google")
    public void capture_title_of_google() {
        System.out.println("Capturing the title");
        title = driver.getTitle();
    }

    @Then("Title should be Google")
    public void title_should_be_google() {
        System.out.println("Validating title");
        Assert.assertEquals(title, "Google");
    }

}
