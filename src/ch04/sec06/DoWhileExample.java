package ch04.sec06;

public class DoWhileExample {
    public static void main(String[] args) {
        int a = 10;

        do {
            a += 10;
            System.out.println(a);
        } while (a > 100);
    }
}
