package ch12.sec03.exam04;

public class RecordExample {
    public static void main(String[] args) {
        Member member = new Member("winter", "눈송이", 25);
        System.out.println(member.id());
        System.out.println(member.name());
        System.out.println(member.age());
        System.out.println(member);

        Member member1 = new Member("winter", "눈송이", 25);
        Member member2 = new Member("winter", "눈송이", 25);
        System.out.println(member1.hashCode());
        System.out.println(member2.hashCode());
        System.out.println(member1.equals(member2));
    }
}
