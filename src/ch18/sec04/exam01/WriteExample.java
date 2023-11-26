package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("/Users/yoon/git/java-study/src/ch18/sec04/exam01/test.txt");

            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            char[] arr = {'C', 'D', 'E'};
            writer.write(arr);

            writer.write("FGH");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
