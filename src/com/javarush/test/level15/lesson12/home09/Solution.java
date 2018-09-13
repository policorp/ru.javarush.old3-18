package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        reader.close();

        ArrayList<String> mas = new ArrayList<String>();
        boolean param = false;
        String curParam = "";
        char curChar = ' ';
        for (int i = 0; i < request.length(); i++) {
            curChar = request.charAt(i);
            if ((curChar == '?') || (curChar == '&')) {
                param = true;
                if (curChar == '&') {
                    mas.add(curParam);
                    curParam = "";
                }
                continue;
            }
            if (param)
                curParam += curChar;
        }
        mas.add(curParam);
        //System.out.println(mas);

        param = false;
        for (String x: mas) {
            if (!(x.contains("="))) {
                System.out.print(x + " ");
                continue;
            }
            if (x.contains("obj"))
                param = true;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) == '=')
                    break;
                System.out.print(x.charAt(i));
            }
            System.out.print(" ");
        }
        System.out.println();

        if (param) {
            for (String x: mas) {
                curParam = "";
                curParam += x.charAt(0);
                curParam += x.charAt(1);
                curParam += x.charAt(2);
                if (!(curParam.equals("obj")))
                    continue;
                curParam = "";
                for (int i = 4; i < x.length(); i++) {
                    curParam += x.charAt(i);
                }
                try {
                    Double value = Double.parseDouble(curParam);
                    alert(value);
                    continue;
                }
                catch (NumberFormatException e) {
                    //e.printStackTrace();
                }
                alert(curParam);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
