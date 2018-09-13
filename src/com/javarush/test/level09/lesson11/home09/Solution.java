package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("fedya", new Cat("gff1"));
        map.put("vasya", new Cat("gff2"));
        map.put("gavril", new Cat("gff3"));
        map.put("vanya", new Cat("gff4"));
        map.put("maxik", new Cat("gff5"));
        map.put("gregory", new Cat("gff6"));
        map.put("serzha", new Cat("gff7"));
        map.put("vitalya", new Cat("gff8"));
        map.put("alexei", new Cat("gff9"));
        map.put("artem", new Cat("gff10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set= new HashSet<Cat>();
        for (Map.Entry<String, Cat> x: map.entrySet()) {
            set.add(x.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
