package com.WebTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D07IndicesDemo {

    @Test(dataProvider = "getData")
    public void demo(int n, String s){
        //System.out.println(n + " - " + s);
    }

    @DataProvider (indices = {2, 4})
    public Object[][]getData(){
        return new Object[][] {
                new Object[] { 1, "a" },
                new Object[] { 2, "b" },
                new Object[] { 3, "c" },
                new Object[] { 4, "d" },
                new Object[] { 5, "e" },
        };
    }
}
