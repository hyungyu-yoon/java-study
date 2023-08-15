package ch06.sec11.exam01;

public class KoreanExample {
    public static void main(String[] args) {
        Korean k1 = new Korean("123456-1234567", "김자바");

        System.out.println(k1.nation);
        System.out.println(k1.ssn);
        System.out.println(k1.name);

//        k1.nation = "미국"; final 변경 불가
        k1.name = "윤자바"; // 변경 가능
    }
}
