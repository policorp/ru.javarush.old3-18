package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream_1 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream_2 = new FileInputStream(reader.readLine());

        byte[] array = new byte[fileInputStream_1.available()];
        fileInputStream_1.read(array);
        fileOutputStream.write(array);
        array = new byte[fileInputStream_2.available()];
        fileInputStream_2.read(array);
        fileOutputStream.write(array);

        reader.close();
        fileOutputStream.close();
        fileInputStream_1.close();
        fileInputStream_2.close();
    }
}
