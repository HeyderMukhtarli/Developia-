package Ders14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
      Date d=new Date();
        System.out.println(d.toString());
        java.sql.Date date2=new java.sql.Date(d.getTime());
        System.out.println(date2.toString());
        LocalTime l=LocalTime.now();
        System.out.println(l);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String s=l.format(formatter);
        System.out.println(s);
        LocalDateTime lt=LocalDateTime.now();
        System.out.println(lt);
        LocalDate ld=LocalDate.parse("2024-05-23");
        System.out.println(ld.toString());
        LocalTime lt2=LocalTime.parse("13:34:22");
        System.out.println(lt2);
        LocalDate ld3=LocalDate.now();
        System.out.println(ld3);
        LocalDate ld4=ld3.plusDays(5);
        System.out.println(ld4);
       LocalTime lt3=LocalTime.now();
        System.out.println(lt3);

        lt3.plusHours(-3);
        System.out.println(lt3);
        LocalTime lt4= lt3.plusHours(-3);
        System.out.println();
    }
}
