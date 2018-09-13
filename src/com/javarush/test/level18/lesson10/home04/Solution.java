package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName_1 = reader.readLine();
        String fileName_2 = reader.readLine();

        FileInputStream fileInputStream_1 = new FileInputStream(fileName_1);
        FileInputStream fileInputStream_2 = new FileInputStream(fileName_2);

        byte[] array_1 = new byte[fileInputStream_1.available()];
        byte[] array_2 = new byte[fileInputStream_2.available()];
        fileInputStream_1.read(array_1);
        fileInputStream_2.read(array_2);
        fileInputStream_1.close();
        fileInputStream_2.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName_1);
        fileOutputStream.write(array_2);
        fileOutputStream.write(array_1);

        fileOutputStream.close();
        reader.close();
    }
}
