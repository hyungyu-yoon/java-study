package ch03.sec04;

public class AccuracyExample {
    public static void main(String[] args) {
        int apple = 1;
        double priceUnit = 0.1;
        int number = 7;

        double result = apple - number * priceUnit;
        System.out.println("사과 1개에서 남은 양 " + result);
    }
}
