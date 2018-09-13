package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFromFile = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        String buffer = readerFromFile.readLine();
        Integer intBuffer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (buffer != null) {
            //System.out.println(buffer);
            try {
                intBuffer = Integer.parseInt(buffer);
                //System.out.println(intBuffer);
            }
            catch (NumberFormatException e) {
                System.out.println("error! wrong data!");
                e.printStackTrace();
            }

            if ((intBuffer % 2) == 0)
                list.add(intBuffer);
            buffer = readerFromFile.readLine();
        }

        for (int i = 0; i < list.size() - 1; i++)
            for (int j = i + 1, buf; j < list.size(); j++)
                if (list.get(i) > list.get(j)) {
                    buf = list.get(i);
                    list.add(i, list.get(j));
                    list.remove(i + 1);
                    list.add(j, buf);
                    list.remove(j + 1);
                }

        for (Integer x: list) {
            System.out.println(x);
        }

        readerFromFile.close();
    }
}
