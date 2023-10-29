package ch15.sec02.exam02;

import ch15.sec02.exam01.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        List<Board> list = new Vector<>();
//        List<Board> list = new ArrayList<>();

        Thread treadA = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
                }
            }
        };

        Thread treadB = new Thread() {
            @Override
            public void run() {
                for (int i = 1001; i <= 2000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
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

        System.out.println("총 객체 수 : " + list.size());
    }
}
