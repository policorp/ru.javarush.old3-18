package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        String buf = null;
        for (int i = 0; i < array.length - 1; i++) {
            //buf = array[i];
            if (isNumber(array[i])) {
                //number max to min
                for (int j = i + 1; j < array.length; j++) {
                    if (!isNumber(array[j]))
                        continue;
                    if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
                        buf = array[j];
                        array[j] = array[i];
                        array[i] = buf;
                    }
                }
            }
            else {
                //word min to max
                for (int j = i + 1; j < array.length; j++) {
                    if (isNumber(array[j]))
                        continue;
                    if (isGreaterThen(array[i], array[j])) {
                        buf = array[j];
                        array[j] = array[i];
                        array[i] = buf;
                    }
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
