package ch05.sec09;

import java.util.Arrays;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldArray = {"java", "array", "copy"};
        String[] newArray = new String[5];

        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        System.out.println(Arrays.toString(newArray));
    }
}
