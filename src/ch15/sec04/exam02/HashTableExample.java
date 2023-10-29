package ch15.sec04.exam02;

import ch15.sec02.exam01.Board;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();
//        Map<String, Integer> map = new HashMap<>();

        Thread treadA = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    map.put(String.valueOf(i), i);
                }
            }
        };

        Thread treadB = new Thread() {
            @Override
            public void run() {
                for (int i = 1001; i <= 2000; i++) {
                    map.put(String.valueOf(i), i);
                }
            }
        };

        treadA.start();
        treadB.start();

        try {
            treadA.join();
            treadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("총 객체 수 : " + map.size());
    }
}
