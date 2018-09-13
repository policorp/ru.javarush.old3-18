package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("lol", new Date("JUNE 1 1900"));
        map.put("lool", new Date("JUNE 1 1900"));
        map.put("lolo", new Date("JUNE 1 1900"));
        map.put("looll", new Date("JUNE 1 1900"));
        map.put("lolol", new Date("JUNE 1 1900"));
        map.put("lolololo", new Date("JUNE 1 1900"));
        map.put("olo", new Date("JUNE 1 1900"));
        map.put("olol", new Date("JUNE 1 1900"));
        map.put("trololo", new Date("JUNE 1 1900"));
        map.put("o", new Date("January 1 1900"));

        //removeAllSummerPeople(map);
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
/*
        HashMap<String, Date> map2 = new HashMap<String, Date>();

        for (Map.Entry<String, Date> pair: map.entrySet()) {
            if ((pair.getValue().getMonth() < 5) && (pair.getValue().getMonth() > 7))
                map2.put(pair.getKey(), pair.getValue());
        }
*/
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            if (((pair.getValue().getMonth() >= 5) && (pair.getValue().getMonth() <= 7)))
                iterator.remove();
        }

        //return map;
    }
}
