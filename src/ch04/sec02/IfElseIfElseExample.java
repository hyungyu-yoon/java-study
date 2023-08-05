package ch04.sec02;

public class IfElseIfElseExample {
    public static void main(String[] args) {
        int score = 70;

        if (score >= 90) {
            System.out.println("점수가 90보다 크고 A등급임다");
        } else if (score >= 80) {
            System.out.println("점수가 90보다 작고 B등급 임다.");
        } else {
            System.out.println("그 외...");
        }
    }
}
