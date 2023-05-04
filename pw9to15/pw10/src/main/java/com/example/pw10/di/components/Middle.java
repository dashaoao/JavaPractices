package com.example.pw10.di.components;

import com.example.pw10.Programmer;

public class Middle implements Programmer {
    @Override
    public void doWork() {
        System.out.println("Middle working...");
    }
}
