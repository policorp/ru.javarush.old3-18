package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = null;
        ArrayList<String> stringList = new ArrayList<String>();

        while (!((text = reader.readLine()).equals("exit"))) {
            stringList.add(text);
        }
        reader.close();

        for (String x: stringList) {
            Double doubleValue = 0.0;
            Integer intValue = 0;
            Short shortValue = 0;

            //DOUBLE
            if (x.contains("."))
                try {
                    doubleValue = Double.parseDouble(x);
                    print(doubleValue);
                    continue;
                }
                catch (NumberFormatException e) {
                    //e.printStackTrace();
                }
            //INT, SHORT
            try {
                intValue = Integer.parseInt(x);
                if (intValue >= 128)
                    print(intValue);
                if ((intValue > 0) && (intValue < 128)) {
                    shortValue = Short.parseShort(x);
                    print(shortValue);
                }
                if (intValue <= 0)
                    print(x);
                continue;
            }
            catch (NumberFormatException e) {
                //e.printStackTrace();
            }

            print(x);
            //System.out.println(doubleValue);
            //System.out.println(intValue);
            //System.out.println(shortValue);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
