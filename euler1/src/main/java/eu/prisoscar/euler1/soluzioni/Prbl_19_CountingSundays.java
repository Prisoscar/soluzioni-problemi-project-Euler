package eu.prisoscar.euler1.soluzioni;

import java.util.HashMap;
import java.util.Map;

/*
You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Prbl_19_CountingSundays {

    public static int getSolution(){
        int solution = 0;
        Map<Integer, Integer> monthDays = new HashMap<Integer, Integer>(){{
            put(1, 31);     //january
            put(2, 28);     //february
            put(3, 31);     //march
            put(4, 30);     //april
            put(5, 31);      //may
            put(6, 30);      //june
            put(7, 31);      //july
            put(8, 31);      //august
            put(9, 30);      //september
            put(10, 31);     //october
            put(11, 30);     //november
            put(12, 31);     //december
        }};
        int weekDay = 1;
        int monthDay = 1;
        int month = 1;
        int year = 1900;
        while (year != 2001){
            weekDay = weekDay == 7 ? 1 : ++weekDay;
            if (isLeapYear(year) && month ==2 && monthDay == 28) weekDay = weekDay == 7 ? 1 : ++weekDay;
            monthDay = monthDay == monthDays.get(month) ? 1 : ++monthDay;
            if (monthDay == 1) month++;
            if (month == 13) month = 1;
            if (monthDay == 31 && month == 12) year++;
            if (monthDay == 1 && weekDay == 7 && year != 1900) solution++;
        }
        return solution;
    }

    private static boolean isLeapYear(int year){
        if(year % 100 == 0 && year % 400 == 0) return true;     //for centuries
        if(year % 4 == 0 && year % 100 != 0) return true;       //for simple years
        return false;
    }
}
