package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName_1 = reader.readLine();
        String fileName_2 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName_1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName_2);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Float> arrayListFloat = new ArrayList<Float>();
        StringBuilder stringBuilder = new StringBuilder();
        while (fileInputStream.available() > 0) {
            char char_buffer = '\0';
            char_buffer = (char)fileInputStream.read();
            if (char_buffer == ' ') {
                if (stringBuilder.length() == 0)
                    continue;
                arrayListFloat.add(Float.parseFloat(stringBuilder.toString()));
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(char_buffer);
            }
        }
        arrayListFloat.add(Float.parseFloat(stringBuilder.toString()));

        for (Float f: arrayListFloat) {
            BigDecimal bigDecimal = new BigDecimal((double)f);
            if (f > 0)
                bigDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
            else
                bigDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_DOWN);
            arrayList.add(Integer.parseInt(bigDecimal.toString()));
        }

        for (Integer i: arrayList) {
            fileOutputStream.write(i.toString().getBytes());
            fileOutputStream.write(' ');
        }

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
