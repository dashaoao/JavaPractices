package com.example.pw10.di.components;

import com.example.pw10.Programmer;

public class Senior implements Programmer {
    @Override
    public void doWork() {
        System.out.println("Senior working...");
    }
}
