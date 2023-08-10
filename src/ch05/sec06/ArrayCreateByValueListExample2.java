package ch05.sec06;

public class ArrayCreateByValueListExample2 {
    public static void main(String[] args) {
        int[] scores;
        scores = new int[]{83, 90, 87};

        int sum1 = 0;
        for (int i = 0; i < 3; i++) {
            sum1 += scores[i];
        }

        System.out.println(sum1);
        printItem(new int[] {10,20,30,40,50});
    }

    public static void printItem(int[] scores) {
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
