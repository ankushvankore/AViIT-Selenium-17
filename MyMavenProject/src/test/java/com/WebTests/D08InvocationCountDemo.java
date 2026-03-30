package com.WebTests;

import org.testng.annotations.Test;

public class D08InvocationCountDemo {
    @Test (invocationCount = 5)
    public void demoTest(){
        System.out.println("This is demo test");
    }
}
