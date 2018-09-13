package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Date today = new Date();
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date)
    {
        Date nowDay = new Date(date);
        Date start = new Date("January 1 " + (nowDay.getYear() + 1900));

        long counter = nowDay.getTime() - start.getTime();
        counter /= (1000*60*60*24);
        counter++;

        if (counter % 2 == 0)
            return false;
        return true;
    }
}
