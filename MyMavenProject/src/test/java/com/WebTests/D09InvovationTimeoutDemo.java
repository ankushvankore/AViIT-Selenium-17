package com.WebTests;

import org.testng.annotations.Test;

public class D09InvovationTimeoutDemo {
    @Test (invocationTimeOut = 2500)
    public void trialTest() throws InterruptedException {
        System.out.println("Test started!!!");

        Thread.sleep(3000);

        System.out.println("Test Ends!!!");
    }
}
