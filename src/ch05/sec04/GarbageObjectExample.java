package ch05.sec04;

public class GarbageObjectExample {
    public static void main(String[] args) {
        String hobby = "여행";
        hobby = null; // GC 대상

        String kind1 = "자동차";
        String kind2 = kind1;
        kind1 = null;
        System.out.println(kind2); // kind1 이 null이 되었지만, kind2가 여전히 자동차 참조

    }
}
