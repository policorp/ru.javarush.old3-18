package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] store = new byte[fileInputStream.available()];
        fileInputStream.read(store);
        int counter = 0;
        for (byte b: store) {
            if ((b >= 65 && b <=90) || (b >= 97 && b <= 122))
                counter++;
        }
        System.out.println(counter);
        fileInputStream.close();
    }
}
