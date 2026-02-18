package com.TestNGDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

//RediffUtility.driver = D10POMClient.driver;

public class D10POMClient{
    WebDriver driver;
    RediffUtility r1;

    @Test
    public void rediffRegistration() throws InterruptedException {
        r1.setFullName("Ila Joshi");
        r1.setRediffId("ilajoshi654789");
        r1.setPassword("ila@123");
        r1.setBirthDate("02", "NOV", "2000");
        r1.selectGender("Female");
        String msg = r1.checkAvailablity();
        Assert.assertTrue(msg.contains("Yippie"));
    }

    @BeforeTest
    public void launchBrowser(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        r1 = new RediffUtility(driver);
    }

    @AfterTest
    public void closeBrowser(){
        //driver.close();
    }
}
