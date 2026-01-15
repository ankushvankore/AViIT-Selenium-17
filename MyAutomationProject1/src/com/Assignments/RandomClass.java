package com.Assignments;

import java.util.Random;

public class RandomClass {
    public static void main(String[] args) {
        Random rnd = new Random();
        int i = rnd.nextInt(10);
        //Return any random no in the range of 0 to 9
        System.out.println(i);
    }
}
