package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arrayLists = new ArrayList[5];

        arrayLists[0] = new ArrayList<String>();
        arrayLists[0].add("Dfdsfsdfdsf");
        arrayLists[1] = new ArrayList<String>();
        arrayLists[1].add("Dfdsfsdfdsf");
        arrayLists[2] = new ArrayList<String>();
        arrayLists[2].add("Dfdsfsdfdsf");
        arrayLists[3] = new ArrayList<String>();
        arrayLists[3].add("Dfdsfsdfdsf");
        arrayLists[4] = new ArrayList<String>();
        arrayLists[4].add("Dfdsfsdfdsf");
        return arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}