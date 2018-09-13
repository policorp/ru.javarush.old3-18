package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (map.containsKey(data)) {
                int value = map.get(data);
                map.remove(data);
                map.put(data, ++value);
            } else {
                map.put(data, 1);
            }
        }

        int max = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            if (max > pair.getValue()) {
                max = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
