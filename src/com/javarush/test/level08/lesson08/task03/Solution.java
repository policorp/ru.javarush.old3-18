package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("dedov", "denic");
        map.put("mukov", "denic");
        map.put("zhukov", "denic");
        map.put("sukob", "denic");
        map.put("qwertig", "denic");
        map.put("lolcov", "denic");
        map.put("erasov", "denic");
        map.put("mudakov", "denic");
        map.put("kolcos", "denic");
        map.put("retardov", "denic");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            if (name.equals(pair.getValue()))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            if (familiya.equals(pair.getKey()))
                count++;
        }
        return count;
    }
}
