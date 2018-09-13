package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int[] array = new int[128];
        for (int x: array) {
            x = 0;
        }

        while (fileInputStream.available() > 0) {
            int buffer = fileInputStream.read();
            array[buffer]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                continue;
            System.out.println((char)i + " " + array[i]);
        }

        fileInputStream.close();
    }
}
