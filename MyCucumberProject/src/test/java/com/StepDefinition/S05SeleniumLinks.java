package com.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S05SeleniumLinks {
    WebDriver driver;

    //@Before
    public void beforeHook(){
        System.out.println("Before Hook Executed");
    }

    //@After
    public void closeBrowser(){
        driver.close();
    }

    @Given("Launch url as {string}")
    public void launch_url_as(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }

    @When("Click on Downloads Link")
    public void click_on_downloads_link() {
        driver.findElement(By.partialLinkText("Downl")).click();
    }

    @Then("Downloads page should open")
    public void downloads_page_should_open() {
        Assert.assertTrue(driver.getCurrentUrl().contains("downloads"));
    }

    @When("Click on Documentation Link")
    public void click_on_documentation_link() {
        driver.findElement(By.partialLinkText("Docume")).click();
    }

    @Then("Documentations page should open")
    public void documentations_page_should_open() {
        Assert.assertTrue(driver.getCurrentUrl().contains("documentation"));
    }

    @When("Click on Projects link")
    public void click_on_projects_link() {
        driver.findElement(By.partialLinkText("Projects")).click();
    }

    @Then("Projects page should open")
    public void projects_page_should_open() {
        Assert.assertTrue(driver.getCurrentUrl().contains("project"));
    }

    @When("Click on Support link")
    public void click_on_support_link() {
        driver.findElement(By.partialLinkText("Support")).click();
    }

    @Then("Support page should open")
    public void support_page_should_open() {
        Assert.assertTrue(driver.getCurrentUrl().contains("support"));
    }
}
