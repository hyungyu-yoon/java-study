package ch04.sec03;

public class SwitchCharExample {
    public static void main(String[] args) {
        char grade = 'a';

        switch (grade) {
            case 'a', 'A' -> System.out.println("우수 회원");
            case 'b', 'B' -> System.out.println("일반 회원");
            default -> System.out.println("회원");
        }
    }
}
