package ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeCompareExample {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        LocalDateTime startDateTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        System.out.println("시작일 : " + startDateTime.format(dtf));

        LocalDateTime endDateTime = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
        System.out.println("종료일 : " + endDateTime.format(dtf));

        if (startDateTime.isAfter(endDateTime)) {
            System.out.println("진행 중입니다.");
        }else if (startDateTime.isEqual(endDateTime)) {
            System.out.println("종료합니다.");
        } else {
            System.out.println("종료했습니다.");
        }

        long remainYears = startDateTime.until(endDateTime, ChronoUnit.YEARS);
        long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
        long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
        long remainHours = startDateTime.until(endDateTime, ChronoUnit.HOURS);
        long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
        long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
        System.out.println(remainYears);
        System.out.println(remainMonth);
        System.out.println(remainDay);
        System.out.println(remainHours);
        System.out.println(remainMinute);
        System.out.println(remainSecond);
    }
}
