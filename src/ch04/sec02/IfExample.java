package ch04.sec02;

public class IfExample {
    public static void main(String[] args) {
        int score = 89;

        if (score >= 90) { // 여기서 한 번 처리
            System.out.println("점수가 90보다 크고 A등급임다");
        }

        if (score < 90) { // 요기는 수행될 필요 없음.. 따라서 else 사용
            System.out.println("점수가 90보다 작고 B등급 임다.");
        }
    }
}
