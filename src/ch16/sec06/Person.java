package ch16.sec06;

public class Person {
    public Member getMember1(Creatable1 creatable1) {
        String id = "winter";
        Member member = creatable1.create(id);
        return member;
    }

    public Member getMember2(Creatable2 creatable1) {
        String id = "winter";
        String name = "한겨울";
        Member member = creatable1.create(id, name);
        return member;
    }
}
