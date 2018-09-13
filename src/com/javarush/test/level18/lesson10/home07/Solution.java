package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        int param = Integer.parseInt(args[0]);

        ArrayList<String> arrayList = new ArrayList<String>();

        StringBuilder builder = new StringBuilder();
        while (fileInputStream.available() > 0) {
            char buffer = (char)fileInputStream.read();
            if (buffer == 10)
                continue;
            if (buffer == 13)
                buffer = ' ';
            if (buffer != ' ') {
                builder.append(buffer);
                continue;
            }
            arrayList.add(builder.toString());
            builder = new StringBuilder();
        }
        arrayList.add(builder.toString());

        int counter = 0;
        String answer = "";
        while (counter != arrayList.size()) {
            int id = Integer.parseInt(arrayList.get(counter));
            StringBuilder productName = new StringBuilder();
            productName.append(arrayList.get(counter + 1));
            int innerCounter = 2;
            for (; ; ) {
                if (arrayList.get(counter + innerCounter).contains("."))
                    break;
                productName.append(" " + arrayList.get(counter + innerCounter));
                innerCounter++;
            }

            double price = Double.parseDouble(arrayList.get(counter + innerCounter));
            int quantity = Integer.parseInt(arrayList.get(counter + innerCounter + 1));

            if (id == param) {
                answer = new String(id + " "
                        + productName.toString() + " "
                        + price + " "
                        + quantity);
                break;
            }

            counter += innerCounter + 2;
        }

        System.out.println(answer);
        reader.close();
        fileInputStream.close();
    }
}
