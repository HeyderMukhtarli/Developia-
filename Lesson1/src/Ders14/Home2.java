package Ders14;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Home2 {
public static void main(String[] args) {
        LocalDate ld=LocalDate.now();
        LocalDate ld2=LocalDate.of(2022,1,23);
        System.out.println(ld.isAfter(ld2));
        LocalDateTime ldt=LocalDateTime.now();

    Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();

    Date date = Date.from(instant);

    System.out.println("Date: " + date);
    LocalDate nextSunday = ld.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

    // Print the next Sunday
    System.out.println("Given Date: " + nextSunday);
    LocalDate date1 = LocalDate.of(2024, 6, 1);
    LocalDate date2 = LocalDate.of(2024, 6, 13);

    // Calculate the difference in days between the two dates
    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
    System.out.println(daysBetween);
    Date d=new Date();
    Instant  instant2 = d.toInstant();

    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    System.out.println("LocalDateTime: " + localDateTime);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println(localDateTime.format(formatter));
    String dateTimeString = "2024-06-13 15:30:00";
    LocalDateTime localDateTime2 = LocalDateTime.parse(dateTimeString, formatter);
    System.out.println(localDateTime2);

    LocalTime startTime = LocalTime.of(9, 0);  // 9:00 AM
    LocalTime endTime = LocalTime.of(11, 30);  // 11:30 AM

    Duration duration = Duration.between(startTime, endTime);

    long hours = duration.toHours();
    long minutes = duration.toMinutesPart();

    int year = LocalDate.now().getYear();  // Get the current year
    boolean isLeapYear = Year.of(year).isLeap();



    java.sql.Date sqlDate = java.sql.Date.valueOf("2024-06-13");  // Example date in yyyy-MM-dd format

    LocalDate localDate = sqlDate.toLocalDate();

    System.out.println("Converted LocalDate: " + localDate);

}
        }
