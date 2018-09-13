package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputFile1 = new FileInputStream(reader.readLine());
        FileOutputStream outputFile2 = new FileOutputStream(reader.readLine());
        FileOutputStream outputFile3 = new FileOutputStream(reader.readLine());

        int half = inputFile1.available() / 2;
        if (half * 2 != inputFile1.available())
            half++;
        byte[] buffer1 = new byte[half];
        inputFile1.read(buffer1);
        outputFile2.write(buffer1);

        byte[] buffer2 = new byte[inputFile1.available()];
        inputFile1.read(buffer2);
        outputFile3.write(buffer2);

        reader.close();
        inputFile1.close();
        outputFile2.close();
        outputFile3.close();
    }
}
