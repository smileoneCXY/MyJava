package com.cxy.java8.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author:chenxiaoyi
 * @Date:2020/1/20 14:35
 */
public class DateUtils {
    public static void main(String[] args) {

        /*LocalDate**/
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().plusDays(1));
        System.out.println(LocalDate.now().minus(1, ChronoUnit.MONTHS));

        LocalDate parse = LocalDate.parse("2020-01-20");
        System.out.println(parse.isLeapYear());

        System.out.println(LocalTime.now());
        System.out.println(LocalTime.MIN+" "+ LocalTime.MIDNIGHT);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        /*Date->LocalDateTime*/
        LocalDateTime dateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        /*LocalDateTime->Date*/
        Date from = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());


    }
}
