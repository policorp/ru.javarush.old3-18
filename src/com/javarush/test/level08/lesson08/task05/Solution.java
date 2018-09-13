package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> mapster = new HashMap<String, String>();
        mapster = createMap();
        printMap(mapster);
        removeTheFirstNameDuplicates(mapster);
        System.out.println();
        printMap(mapster);
    }

    public static void printMap(HashMap<String, String> map) {
        for (Map.Entry<String, String> x: map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("qwe", "family");
        map.put("q", "famrrily");
        map.put("ewqeq", "famrrrily");
        map.put("121", "famrrrily");
        map.put("wqeq2", "family");
        map.put("ewqeqwe1", "famrwerily");
        map.put("eqweqweq", "family");
        map.put("eqw134", "famirwly");
        map.put("wq3456", "farwermily");
        map.put("eqwe99", "family");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> map2 = new HashMap<String, String>(map);
        HashMap<String, String> map3 = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair: map2.entrySet()) {
            map3.remove(pair.getKey());
            if (map3.containsValue(pair.getValue())) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
