package ch05.sec06;

import java.util.Arrays;

public class ArrayLengthExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        int sum = Arrays.stream(array).sum();
        double avg = (double) sum / array.length;
        System.out.println(avg);

        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
    }
}
