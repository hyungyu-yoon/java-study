package ch03.sec07;

public class LogicalOperatorExample {
    public static void main(String[] args) {
        int charCode = 'A';

        if ((65 <= charCode) && (charCode <= 90)) {
            System.out.println("대문자");
        }

        int a = 5;
        if (!(a % 2 == 0 || a % 3 == 0)) {
            System.out.println("2 또는 3의 배수가 아니야~");
        }
    }
}
