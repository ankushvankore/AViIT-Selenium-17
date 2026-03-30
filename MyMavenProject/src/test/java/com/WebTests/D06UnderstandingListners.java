package com.WebTests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.WebTests.MyDemoListners.class)
public class D06UnderstandingListners {
    @Test (priority = 1)
    public void passTest(){
        System.out.println("Test 1 Started!!!");
        Assert.assertTrue(true);
    }

    @Test (priority = 2)
    public void failTest(){
        System.out.println("Test 2 Started!!!");
        Assert.assertTrue(false);
    }

    @Test (priority = 3)
    public void skipTest(){
        System.out.println("Test 3 Started!!!");
        throw new SkipException("Skipping this test for demo purpose");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}
