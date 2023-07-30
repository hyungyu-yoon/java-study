package ch02.sec11;

public class VariableScopeExample {
    public static void main(String[] args) {
        int v1 = 10;
        if(v1 > 10) {
            int v2 = v1 - 10;
        }


//        System.out.println(v1 + v2); // 불가
    }
}
