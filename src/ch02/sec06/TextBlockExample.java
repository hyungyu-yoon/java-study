package ch02.sec06;

public class TextBlockExample {
    public static void main(String[] args) {
        String text = "" +
                "{\n" +
                "\t\"id\":\"winter\",\n" +
                "\t\"name\":\"눈송이\"\n" +
                "}";
        System.out.println(text);

        String block = """
                {
                	"id":"winter",
                	"name":"눈송이"
                }
                """;
        System.out.println(block);


        System.out.println("""
                 나는 자바를 \
                 학습합니다.
                 나는 자바 고수가 될거야..
                """);
    }
}
