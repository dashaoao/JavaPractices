package pw3;

import pw3.MySet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MySet<Integer> set = new MySet<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 21; i++) {
                set.add(i);
            }
        });

        thread1.start();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync list:");
        set.forEach(System.out::println);
    }
}