package ch08.sec13;

public class SealedExample {
    public static void main(String[] args) {
        ImplClass implClass = new ImplClass();

        InterfaceA ia = implClass;
        ia.methodA();

        System.out.println();

        InterfaceB ib = implClass;
        ib.methodA();
        ib.methodB();

        System.out.println();

        InterfaceC ic = implClass;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
