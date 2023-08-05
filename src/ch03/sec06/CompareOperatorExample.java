package ch03.sec06;

public class CompareOperatorExample {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println(num1 == num2);
        System.out.println(num1 != num2);
        System.out.println(num1 <= num2);

        System.out.println('A' < 'B');

        System.out.println(1 == 1.0);

        System.out.println(1.0f == (float) 1.0);
    }
}
