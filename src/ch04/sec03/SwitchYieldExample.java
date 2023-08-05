package ch04.sec03;

public class SwitchYieldExample {
    public static void main(String[] args) {
        char grade = 'A';

        int score = switch (grade) {
            case 'A' -> {
                System.out.println("100점!");
                yield 100;
            }
            case 'B' -> {
                System.out.println("90점.");
                yield 90;
            }
            default -> 0;
        };
        System.out.println(score);
    }
}
