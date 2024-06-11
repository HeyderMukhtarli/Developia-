package ders15;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class MainDates {
    public static void main(String[] args) {
        //  single thread

        // 1-ci hal cari zamani tapmaq
        LocalDate dateNow=LocalDate.now();
        System.out.println(dateNow);
// meselen burada 1 ay ceken bir kod olsaydi
        LocalDate dateOf=LocalDate.of(2024,6,1);
        System.out.println(dateOf);

        LocalTime zaman=LocalTime.now();
        System.out.println(zaman);

        LocalTime zamanOf=LocalTime.of(15,55,44);
        System.out.println(zamanOf);

        System.out.println(System.currentTimeMillis());
        System.out.println("-------------");
        LocalDateTime hamsi=LocalDateTime.now();
        System.out.println(hamsi);
        String ay=dateOf.getMonth().toString();
        System.out.println(ay);

        long ferq=ChronoUnit.WEEKS .between(dateOf,dateNow);
        System.out.println(ferq);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        String strDate = dateFormat.format(date);
        System.out.println("Converted String: " + strDate);

        // dd-yyyy-MM
    }
}
