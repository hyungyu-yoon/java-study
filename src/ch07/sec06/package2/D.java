package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class D extends A {
    public D() {
        super();
    }

    public void method1() {
        // 상속한 부모 필드, 메서드 사용 가능
        this.field = "value";
        this.method();
    }

    public void method2() {
        // 객체를 직접 생성해서 사용하는 것은 불가
//        A a = new A();
//        a.field = "value";
//        a.method();
    }
}
