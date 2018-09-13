package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static List<String> allLinesCopy = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));

        String buf = "";
        while ((buf = reader1.readLine()) != null) {
            allLines.add(buf);
        }
        while ((buf = reader2.readLine()) != null) {
            forRemoveLines.add(buf);
        }

        reader.close();
        reader1.close();
        reader2.close();

        allLinesCopy = new ArrayList<String>(allLines);

        try {
            new Solution().joinData();
        }
        catch (CorruptedDataException e) {
            //
        }
        catch (Exception e) {
            throw e;
        }

        allLines = allLinesCopy;
    }

    public void joinData () throws CorruptedDataException {
        if (allLinesCopy.containsAll(forRemoveLines)) {
            allLinesCopy.removeAll(forRemoveLines);
        } else {
            allLinesCopy.clear();
            throw new CorruptedDataException();
        }
    }
}
