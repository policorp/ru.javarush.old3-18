package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Vasya", true, 10);
        Human child2 = new Human("Serezha", true, 15);
        Human child3 = new Human("Denis", true, 18);

        ArrayList<Human> children = new ArrayList<Human>(3);
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human Father = new Human("Oleg", true, 40, children);
        Human Mother = new Human("Tanya", false, 35, children);

        children = new ArrayList<Human>(1);
        children.add(Father);
        Human grandFather1 = new Human("Maksim", true, 80, children);
        Human grandMother1 = new Human("Katya", false, 82, children);

        children = new ArrayList<Human>(1);
        children.add(Mother);
        Human grandFather2 = new Human("Volodya", true, 79, children);
        Human grandMother2 = new Human("Olya", false, 78, children);

        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>(0);

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age)
        {

            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }

}
