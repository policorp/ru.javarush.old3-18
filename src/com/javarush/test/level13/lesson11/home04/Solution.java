package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream outStream = new FileOutputStream(reader.readLine());

        String buf = "";

        while (!buf.equals("exit")) {
            buf = reader.readLine();
            outStream.write((buf + "\n").getBytes());
        }

        reader.close();
        outStream.close();
    }
}
