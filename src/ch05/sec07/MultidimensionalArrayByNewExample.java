package ch05.sec07;

public class MultidimensionalArrayByNewExample {
    public static void main(String[] args) {
        int[][] mathScores = new int[2][3];

        for (int i = 0; i < mathScores.length; i++) {
            for (int j = 0; j < mathScores[i].length; j++) {
                mathScores[i][j] = i*j+90;
                System.out.println(mathScores[i][j]);
            }
        }
    }
}
