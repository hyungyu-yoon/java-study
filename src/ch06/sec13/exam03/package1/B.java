package ch06.sec13.exam03.package1;

public class B {
    public void method() {
        A a = new A();

        a.field1 = 1; // o
        a.field2 = 1; // o
//        a.field3 = 1; // x

        a.method1();
        a.method2();
//        a.method3(); 접근불가
    }
}
