package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        List<Integer> list = new LinkedList<Integer>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (list.contains(data))
                continue;
            if (list.isEmpty()) {
                list.add(data);
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                if (data < list.get(i)) {
                    list.add(i, data);
                    break;
                }
                if (i + 1 == list.size()) {
                    list.add(data);
                    break;
                }
            }
        }

        for (Integer x: list) {
            System.out.print(x + " ");
        }

        inputStream.close();
    }
}
