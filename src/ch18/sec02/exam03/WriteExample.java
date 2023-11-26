package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("/Users/yoon/git/java-study/src/ch18/sec02/exam03/test.db");

            byte[] a = {10, 20, 30, 40, 50};

            os.write(a, 1, 3);

            os.flush();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
