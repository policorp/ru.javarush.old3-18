package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        byte[] array = new byte[fileInputStream.available()];
        int spaceCounter = 0;
        int otherCounter = fileInputStream.read(array);

        for (byte b: array) {
            if (b == 32)
                spaceCounter++;
        }

        float result = (float)spaceCounter/otherCounter*100;
        System.out.format("%.2f", result);
        fileInputStream.close();
    }
}
