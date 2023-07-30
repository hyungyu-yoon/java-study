package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x 값 입력: ");
        String strX = sc.nextLine();
        int x = Integer.parseInt(strX);
        System.out.println("x = " + x);
    }
}
