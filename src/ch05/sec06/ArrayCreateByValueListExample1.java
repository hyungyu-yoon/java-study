package ch05.sec06;

public class ArrayCreateByValueListExample1 {
    public static void main(String[] args) {
        String[] seasons = {"Spring", "Summer", "Fall", "Winter"};

        for (String season : seasons) {
            System.out.println(season);
        }

        seasons[2] = "가을";
        for (String season : seasons) {
            System.out.println(season);
        }
    }
}
