package com.WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class D10DependsOnDemo {
    @Test
    public void login(){
        System.out.println("Login test started");
        Assert.assertTrue(false);
        System.out.println("Login test ends");
    }

    @Test (dependsOnMethods = "login")
    public void logout(){
        System.out.println("Logout test started");
        System.out.println("Logout test ends");
    }
}
