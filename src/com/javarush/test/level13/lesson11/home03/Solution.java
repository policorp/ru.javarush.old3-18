package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        InputStream inFile = new FileInputStream(path);
        OutputStream out = new PrintStream(System.out);
        while (inFile.available() > 0) {
            out.write(inFile.read());
        }

        reader.close();
        inFile.close();
        out.close();
    }
}
