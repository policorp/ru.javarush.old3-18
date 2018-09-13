package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        int weight;
        int age;
        boolean female;
        String firstName;
        String lastName;
        String address;

        public Human() {
            super();
            weight = 50;
            age = 18;
            female = false;
            firstName = "First name";
            lastName = "Last name";
            address = "Moscow city";
        }

        public Human(int weight)
        {
            this();
            this.weight = weight;
        }

        public Human(boolean female)
        {
            this();
            this.female = female;
        }

        public Human(String firstName)
        {
            this();
            this.firstName = firstName;
        }

        public Human(int weight, int age)
        {
            this();
            this.weight = weight;
            this.age = age;
        }

        public Human(int weight, boolean female)
        {
            this();
            this.weight = weight;
            this.female = female;
        }

        public Human(int weight, String firstName)
        {
            this();
            this.weight = weight;
            this.firstName = firstName;
        }

        public Human(int weight, int age, boolean female)
        {
            this();
            this.weight = weight;
            this.age = age;
            this.female = female;
        }

        public Human(int weight, int age, String firstName)
        {
            this();
            this.weight = weight;
            this.age = age;
            this.firstName = firstName;
        }

        public Human(int weight, int age, boolean female, String firstName, String lastName, String address)
        {
            this();
            this.weight = weight;
            this.age = age;
            this.female = female;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
        }
    }
}
