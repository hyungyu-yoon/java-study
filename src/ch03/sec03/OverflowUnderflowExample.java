package ch03.sec03;

public class OverflowUnderflowExample {
    public static void main(String[] args) {
        byte v1 = 125;
        for (int i = 0; i < 5; i++) {
            System.out.println(v1++);
        }

        System.out.println("====");
        byte v2 = -125;
        for (int i = 0; i < 5; i++) {
            System.out.println(v1--);
        }
    }
}
