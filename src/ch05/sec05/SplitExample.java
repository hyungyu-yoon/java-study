package ch05.sec05;

public class SplitExample {
    public static void main(String[] args) {
        String board = "1,자바 학습,참조 타입 String을 학습.,홍길동";

        String[] tokens = board.split(",");
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
