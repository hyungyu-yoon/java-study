package ch05.sec07;

public class MultidimensionalArrayByValueListExample {
    public static void main(String[] args) {
        int[][] scores = {
                {80,90, 96},
                {76, 88}
        };

        System.out.println(scores.length);
        System.out.println(scores[0].length);
        System.out.println(scores[1].length);

        int[][]arr2=new int[3][];
        arr2[0]=new int[10];
        arr2[1]=new int[20];
        arr2[2]=new int[30];
    }
}
