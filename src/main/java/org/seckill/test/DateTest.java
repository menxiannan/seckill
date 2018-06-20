package org.seckill.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 12084
 * @create 2018-06-20 14:22
 */

public class DateTest {

    public static void main(String[] args) {
        t2();

    }

    public static void t2() {
        try {
            Calendar c1 = Calendar.getInstance();
            int year = c1.get(Calendar.YEAR);
            int month = c1.get(Calendar.MONTH) + 1;
            int date = c1.get(Calendar.DATE);
            int hour = c1.get(Calendar.HOUR_OF_DAY);




        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void t1() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss a zzz");

        System.out.println(sdf.format(date));
        System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
    }
}
