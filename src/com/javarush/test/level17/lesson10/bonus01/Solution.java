package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        char command = args[0].charAt(1);
        int length = args.length;

        //create -c name sex bd
        if (command == 'c' && length == 4) {
            char sex = Character.toLowerCase(args[2].charAt(0));

            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date birthDate = formater.parse(args[3]);

            if (sex == 'м') {
                allPeople.add(Person.createMale(args[1], birthDate));
            } else {
                allPeople.add(Person.createFemale(args[1], birthDate));
            }
            System.out.println(allPeople.size() - 1);
        }

        //update -u id name sex bd
        if (command == 'u' && length == 5) {
            int id = Integer.parseInt(args[1]);
            char sex = Character.toLowerCase(args[3].charAt(0));

            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date birthDate = formater.parse(args[4]);

            Person someP = null;
            if (sex == 'м') {
                someP = Person.createMale(args[2], birthDate);
            } else {
                someP = Person.createFemale(args[2], birthDate);
            }

            allPeople.add(id, someP);
            allPeople.remove(id + 1);
        }

        //delete -d id
        if (command == 'd' && length == 2) {
            int id = Integer.parseInt(args[1]);
            Person someP = Person.createFemale("", new Date(0, 0, 0));
            allPeople.add(id, someP);
            allPeople.remove(id + 1);
        }

        //info -i id
        if (command == 'i' && length == 2) {
            int id = Integer.parseInt(args[1]);
            Person someP = allPeople.get(id);
            System.out.print(someP.getName() + " ");
            if (someP.getSex() == Sex.MALE)
                System.out.print("м" + " ");
            else
                System.out.print("ж" + " ");
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(formatDate.format(someP.getBirthDay()));
        }

//        printAll();
    }

//    public static void printAll() {
//        for (Person x: allPeople) {
//            System.out.print(x.getName() + " ");
//            if (x.getSex() == Sex.MALE)
//                System.out.print("м" + " ");
//            else
//                System.out.print("ж" + " ");
//            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//            System.out.println(formatDate.format(x.getBirthDay()));
//        }
//    }
}
