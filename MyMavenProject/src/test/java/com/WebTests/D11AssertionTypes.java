package com.WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D11AssertionTypes {
    /*
    Assertion - Technique of marking any test as pass or fail
    Types
        1. Hard Assert (Assert)
            Will mark the test as fail and will terminate the script
        2. Soft Assert (Verify)
            Will continue with the execution even after Assert fail, and will mark the test as fail
            when you will call assertAll() method
     */

    @Test
    public void hardAssertionDemo(){
        System.out.println("Test 1 started!!!");

        Assert.assertTrue(false);

        System.out.println("Test 1 Ends!!!");
    }

    @Test
    public void softAssertionDemo(){
        SoftAssert s1 = new SoftAssert();
        System.out.println("Test 2 Started!!!");
        s1.assertTrue(false);
        System.out.println("Test 2 ends!!!");
        s1.assertAll();
    }
}
