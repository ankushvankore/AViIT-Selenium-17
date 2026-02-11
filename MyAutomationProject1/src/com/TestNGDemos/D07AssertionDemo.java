package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class D07AssertionDemo {
    String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", actUrl;

    WebDriver driver;
    @Test(dataProvider = "getLoginData")
    public void login(String un, String ps){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        actUrl = driver.getCurrentUrl();
        //Assert.assertEquals(actUrl, expUrl);
        //Assert.assertTrue(actUrl.equals(expUrl));
        Assert.assertTrue(actUrl.contains("dashboard"));
    }

    @DataProvider
    public Object[][] getLoginData(){
        Object[][]data = {
                new Object[] {"admin", "admin123"},
                new Object[] {"ila", "ila123"},
                new Object[] {"shri", "shri123"},
                new Object[] {"admin", "admin123"}
        };

        return  data;
    }

    @BeforeTest
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @AfterMethod
    public void logout(){
        if(driver.getCurrentUrl().contains("dashboard")) {
            driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
            driver.findElement(By.linkText("Logout")).click();
            System.out.println("Test case pass");
        }
        else {
            System.out.println("Test case fail");
        }
    }
}
