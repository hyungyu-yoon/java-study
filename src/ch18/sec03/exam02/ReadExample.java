package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("/Users/yoon/git/java-study/src/ch18/sec02/exam02/test.db");

            byte[] data = new byte[100];

            while (true) {
                int num = is.read(data); // 최대 100 byte, 읽은 수 리턴
                if (num == -1) break;

                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }

            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
