package ch03.sec05;

public class InfinityAndNaNCheckExample {
    public static void main(String[] args) {
        double x = 5 / 0.0;
        double y = 5 % 0.0;

        System.out.println("x = " + x);
        System.out.println(Double.isInfinite(x));
        System.out.println();
        System.out.println("y = " + y);
        System.out.println(Double.isNaN(y));
    }
}
