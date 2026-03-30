package com.WebTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyDemoListners implements ITestListener {
    public void onStart(ITestContext result)
    {
        System.out.println("Test / Class started");
    }
    public void onFinish(ITestContext result)
    {
        System.out.println("Test / Class Ends");
    }
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test " + result.getName() + " failed");
    }
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test " + result.getName() + " skipped");
    }
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test " + result.getName() + " started");
    }
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test " + result.getName() + " passed!");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }
    public void onTestFailedWithTimeout(ITestResult result)
    {

    }
}
